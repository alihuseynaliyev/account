FROM openjdk:11.0.7-jre-slim

COPY target/account-0.0.1-SNAPSHOT.jar account-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/account-0.0.1-SNAPSHOT.jar"]