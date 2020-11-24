package com.ebayai.model;

import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.catalyst.encoders.ExpressionEncoder;
import org.apache.spark.sql.catalyst.encoders.RowEncoder;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EuclideanDistanceMapFunction implements MapFunction<Row, Row>, Serializable {
    List<Float> refDescriptors;

    public EuclideanDistanceMapFunction(List<Float> refDescriptors){
        this.refDescriptors =  refDescriptors;
    }
    /***********************************
     *
     **********************************/
    @Override
    public Row call(Row row) throws Exception {
        List<Float> descriptors = row.getList(2);

        double distance = 0;

        for(int i=0; i < refDescriptors.size(); ++i){
            float dist = refDescriptors.get(i) - descriptors.get(i);
            distance += dist * dist;
        }

        return RowFactory.create(row.get(0), row.get(3), row.get(1), distance);
    }
    /***********************************
     *
     **********************************/
    public static ExpressionEncoder<Row> getEncoder(){
        List<StructField> listOfStructField = new ArrayList<StructField>();
        listOfStructField.add(DataTypes.createStructField("itemId", DataTypes.LongType, true));
        listOfStructField.add(DataTypes.createStructField("catId", DataTypes.IntegerType, true));
        listOfStructField.add(DataTypes.createStructField("url", DataTypes.StringType, true));
        listOfStructField.add(DataTypes.createStructField("dist", DataTypes.DoubleType, true));

        StructType structType = DataTypes.createStructType(listOfStructField);

        return  RowEncoder.apply(structType);
    }
}
