FROM eclipse-temurin:11-jdk-alpine

VOLUME /app

COPY target/*.jar main.jar

ENTRYPOINT ["java","-jar","/main.jar"]