# spark-spring-image-search

##Build and packaging:

###Make sure you have maven installed:
https://maven.apache.org/install.html

###Set Properties:
Make sure the properties in `src/main/resources/application.properties` are set properly.

- **server.port** defines the port number for http connection
- **avro** should points to the data (.avro) file
- **avsc** should points to the schema (.avsc) file
- **partition.path** sets the folder in which the preprocessed data is stored
- **log4j.rootCategory** sets the log level, setting it to lower than INFO will drastically imapact the perdormance as it will increase number of io operation

###Command to build and package the project:
`mvn clean package`

This should add a uberjar to the target `./target/spring-boot-0.0.1-SNAPSHOT.jar`

##Run:
Initially we need to preprocecss the avro. To do so  we can run `java -jar target/spring-boot-0.0.1-SNAPSHOT.jar partition=true`
Optionally you can limit number of rows which will be preprocessed by setting `take={number}`

As an example `java -jar target/spring-boot-0.0.1-SNAPSHOT.jar partition=true take=1000` only pre process 1000 rows

After pre processing we can start the server by running `java -jar target/spring-boot-0.0.1-SNAPSHOT.jar`

It will start a jetty webserver at server.port and a Spark UI at port 4040

##Deploy as a container:
To create a Docker image run `docker build -t spark-spring-image-search .`

To deploy, run `docker run -it -d -p 80:80 -p 4040:4040 -v {partition.path}:/{partition.path} spark-spring:latest `

