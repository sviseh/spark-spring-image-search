package com.ebayai.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.util.Properties;

public class Props {
    private static Logger logger = LogManager.getLogger(Props.class);
    private static Properties props;

    private static void init(){
        try{
            Resource resource = new ClassPathResource("application.properties");

            Props.props = PropertiesLoaderUtils.loadProperties(resource);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    /***********************************
     *
     **********************************/
    public static String getParam(String key){
        if(props == null){
            init();
        }

        String result = null;

        try {
            if(props.containsKey(key)){
                result = props.getProperty(key);
            }
        } catch(Exception e){
            logger.error("######### could not find the property "+key);
        }

        return result;
    }
}
