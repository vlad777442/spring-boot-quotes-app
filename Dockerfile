FROM openjdk:17-alpine
COPY target/*.jar QuotesManager-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/QuotesManager-0.0.1-SNAPSHOT.jar"]