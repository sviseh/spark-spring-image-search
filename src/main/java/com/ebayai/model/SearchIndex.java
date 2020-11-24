package com.ebayai.model;

import com.ebayai.server.Context;
import com.ebayai.server.SparkDB;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public class SearchIndex {
    private SparkDB sdb;

    public SearchIndex(){
        sdb = (SparkDB) Context.getCtx().getBean("sparkDB");
    }
    /***********************************
     *
     **********************************/
    public Row findItem(long itemId){
        return sdb.ds().filter("itemId = "+itemId).first();
    }
    /***********************************
     *
     **********************************/
    public Dataset<Row> getCategoryItems(long categoryId){
        Dataset<Row> result = sdb.ds().filter("leaf_categ_id = "+categoryId).distinct().cache();

        return result;
    }
    /***********************************
     *
     **********************************/
    public long count(){
        return  sdb.ds().count();
    }
}
