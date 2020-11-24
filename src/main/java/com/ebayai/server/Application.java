package com.ebayai.server;

import com.ebayai.model.AvroPreProcessing;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
@ImportResource("classpath:config.xml")
public class Application {
	static  Logger logger = LogManager.getLogger(Application.class);

	private static Map<String, String> arguments;

	public static void main(String[] args) {
		Application.processArgs(args);

		if(Application.argExist("partition", new String[]{"1", "true"})){
			AvroPreProcessing.partitionSaveParquet();
		} else {
			ApplicationContext ctx = SpringApplication.run(Application.class, args);
		}
	}
	/***********************************
	 *
	 **********************************/
	public static void processArgs(String[] args){
		Application.arguments = Arrays.stream(args)
				.map(str->{return str.toLowerCase().split("=");})
				.collect(Collectors.toMap(arr->arr[0], arr->arr[1], (k1,k2)->k2));
	}
	/***********************************
	 *
	 **********************************/
	public static String getArg(String arg){
		return arguments.getOrDefault(arg, "");
	}
	/***********************************
	 *
	 **********************************/
	public static boolean argExist(String name, String[] values){
		String value = Application.getArg(name);

		return Arrays.stream(values).filter(str->str.equals(value)).findFirst().isPresent();
	}
}
