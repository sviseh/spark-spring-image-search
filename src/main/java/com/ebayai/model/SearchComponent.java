package com.ebayai.model;


import com.ebay.coreai.Item;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class SearchComponent {
    Logger logger = LogManager.getLogger(SearchComponent.class);

    SortedSet<Pair<Double, ItemInfo>> similarItems;
    private long itemId;

    public SearchComponent(long itemId){
        this.itemId = itemId;
    }
    /***********************************
     *
     **********************************/
    public void addPair(Pair<Double, ItemInfo> pair, int num){
        if(similarItems == null){
            similarItems = new TreeSet<>((Pair<Double, ItemInfo> p1, Pair<Double, ItemInfo> p2)->{
                int comp = p1.first.compareTo(p2.first);
                return comp == 0 ? p1.second.getItemId().compareTo(p2.second.getItemId()): comp;
            });
        }

        if(num == 0){
            similarItems.add(pair);
            return;
        }

        double dist = pair.first;

        if(similarItems.size() < num){
            similarItems.add(pair);
        } else  if(dist < similarItems.last().first) {
            ((TreeSet<Pair<Double, ItemInfo>>) similarItems).pollLast();

            similarItems.add(pair);
        }
    }
    /***********************************
     *
     **********************************/
    public List<ItemInfo> findSimilar(int num){
        long start = new  Date().getTime();
        similarItems = null;
        SearchIndex si = new SearchIndex();

        Item refItem = this.castRowToItem(si.findItem(itemId));
        Dataset<Row> categoryItems = si.getCategoryItems(refItem.getLeafCategId());
        List<Float> descriptors = refItem.getEmbedding();

        Dataset<Row> distances = categoryItems.map(new EuclideanDistanceMapFunction(descriptors), EuclideanDistanceMapFunction.getEncoder());

        Iterator<Row> iterator = distances.toLocalIterator();

        while(iterator.hasNext()) {
            Row di = iterator.next();

            Double dist = di.getDouble(3);

            ItemInfo item = new ItemInfo(di.getLong(0), (long) di.getInt(1), di.getString(2));

            this.addPair(new Pair<>(dist, item), num);
        }

        logger.warn("exec time: "+(new Date().getTime() - start) / 60000.0);

        return this.similarItems.stream().map(_e->_e.second).collect(Collectors.toList());
    }
    /***********************************
     *
     **********************************/
    private Item castRowToItem(Row r){
        Item i = new Item();

        i.setGalleryUrl(r.getString(1));
        i.setEmbedding(r.getList(2));
        i.setItemId(r.getLong(0));
        i.setLeafCategId((long)r.getInt(3));

        return i;
    }/***********************************
     *
     **********************************/
    public static ItemInfo castRowToItemInfo(Row r){
        long l = r.getAs("itemId");
        ItemInfo i = new ItemInfo(r.getLong(0), r.getInt(3), r.getString(1));

        return i;
    }
}
