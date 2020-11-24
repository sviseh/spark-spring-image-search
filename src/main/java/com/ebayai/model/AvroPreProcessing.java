package com.ebayai.model;

import com.ebayai.server.Application;
import com.ebayai.server.Props;
import com.ebayai.server.SparkDB;
import org.apache.avro.Schema;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//    Done!  820543
//    169291 : 509092
//    63861 : 1348416
//    15687 : 693336
//    15709 : 449156

public class AvroPreProcessing {
    static Logger logger = LogManager.getLogger(AvroPreProcessing.class);

    public static void partitionSaveParquet(){
        logger.warn("Start Partitioning...");

        try{
            SparkDB pdb = new SparkDB(false);

            Schema schema = new Schema.Parser().parse(new File(Props.getParam("avsc")));

            logger.warn("Make sure you have enough disk space.");

            String partitionPath = Props.getParam("partition.path");

            if( new File(partitionPath).isDirectory()) {
                logger.error("Partition directory <"+partitionPath+"> exist. Stoped partitioning.");
            } else {
                Dataset<Row> ds = pdb.getCtx().read().format("avro")
                        .option("header", "true")
                        .option("avroSchema", schema.toString())
                        .load(Props.getParam("avro"));

                String takeArg = Application.getArg("take");
                if(! takeArg.equals("")){
                    logger.warn("Limiting Rows to "+takeArg+".");

                    int take = Integer.parseInt(takeArg);
                    ds = AvroPreProcessing.take(ds, pdb.getSession(), take);
                }

                ds.write().option("header", "true")
                        .partitionBy("leaf_categ_id")
                        .parquet(partitionPath);
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }
    /***********************************
     *
     **********************************/
    public static Dataset<Row> take(Dataset<Row> ods, SparkSession ss, int take){
        List<Row> data = new ArrayList<>();
        Iterator<Row> it =  ods.toLocalIterator();
        int counter = 0;

        while(it.hasNext() && counter++ < take){
            data.add(it.next());
        }

        return ss.createDataFrame(data, ods.schema());
    }
}
