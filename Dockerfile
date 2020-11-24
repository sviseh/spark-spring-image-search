FROM openjdk:8

ADD target/spring-boot-0.0.1-SNAPSHOT.jar server.jar
ADD src/main/webapp src/main/webapp

ENTRYPOINT ["java", "-jar", "server.jar"]

EXPOSE 80
EXPOSE 4040
