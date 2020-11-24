package com.ebayai.server;

import com.ebayai.model.ItemInfo;
import com.ebayai.model.SearchComponent;
import com.ebayai.model.SearchIndex;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ApiController {

    @RequestMapping(value="/itm/{itemId}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public List<ItemInfo> itemSearch(@PathVariable("itemId") long itemid) throws IOException {
        SearchComponent sc = new SearchComponent(itemid);
        List<ItemInfo> result = sc.findSimilar(50);

        return result;
    }
    /***********************************
     *
     **********************************/
    @RequestMapping(value="/itminfo/{itemId}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public ItemInfo itminfo(@PathVariable("itemId") long itemId) throws IOException {
        SearchIndex si = new SearchIndex();
        ItemInfo item = SearchComponent.castRowToItemInfo(si.findItem(itemId));

        return item;
    }
    /***********************************
     *
     **********************************/
    @RequestMapping(value="/itm/count", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public long itemSearch() {
        SearchIndex si = new SearchIndex();

        return si.count();
    }
    /***********************************
     *
     **********************************/
    @RequestMapping(value="/cat/{catId}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public List<ItemInfo> catSearch(@PathVariable("catId") long catId) {
        SearchIndex si = new SearchIndex();
        Dataset<Row> d = si.getCategoryItemIterator(catId);

        StringBuilder sb = new StringBuilder();
        int count = 0;

        Iterator<Row> it = d.toLocalIterator();

        List<ItemInfo> result = new ArrayList<>();
        while(it.hasNext() && count++ < 100){
            Row row = it.next();

            result.add(SearchComponent.castRowToItemInfo(row));
        }

        return result;
    }
}
