package com.ebayai.server;

import org.apache.log4j.Level;
import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SparkSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SparkDB {
    private static int numInstances = 0;
    Logger logger = LogManager.getLogger(SparkDB.class);

    private static Dataset<Row> ds;
    private static SparkSession ss;
    private SQLContext sqlCtx;

    private void initializeContext(){
        SparkConf sc = new SparkConf().setAppName("EbayAI").setMaster("local[*]");
        sc.set("spark.driver.memory", "56g");
        sc.set("spark.executor.cores", "2");
        sc.set("spark.executor.instances", "8");
        sc.set("spark.executor.memory", "5g");
        sc.set("spark.cores.max", "16");

        SparkContext sctx = new SparkContext(sc);
        sctx.setLogLevel("ERROR");

        ss = new SparkSession(sctx);
        ss.conf().set("spark.executor.instances", 8);
        ss.conf().set("spark.executor.cores", 2);
        ss.conf().set("spark.cores.max", 16);
        ss.conf().set("spark.executor.memory", "5g");

        sqlCtx = new SQLContext(ss);
    }
    /***********************************
     *
     **********************************/
    public void load(){
        logger.warn("Start loading ...");
        ds =  sqlCtx.read().option("header", "true").load(Props.getParam("partition.path"));
        logger.warn("Loaded and ready  to  GO!");

        //ds.persist();
        //ds.count();
    }
    /***********************************
     *
     **********************************/
    private void construct(boolean load){
        if(numInstances > 0){
            logger.error("Initializing Spark Context more than once :|. Check your logic please.");
        }
        this.initializeContext();

        if(load){
            this.load();
        }

        ++numInstances;
    }
    /***********************************
     *
     **********************************/
    public SparkDB(boolean load){
        construct(load);
    }
    /***********************************
     *
     **********************************/
    public SparkDB(){
        construct(true);
    }
    /***********************************
     *
     **********************************/
    public Dataset<Row> ds(){
        return ds;
    }
    /***********************************
     *
     **********************************/
    public SQLContext getCtx(){
        return sqlCtx;
    }
    /***********************************
     *
     **********************************/
    public SparkSession getSession(){
        return ss;
    }
}

