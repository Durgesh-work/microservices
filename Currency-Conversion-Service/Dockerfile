FROM openjdk:18.0-slim
COPY target/*.jar app.jar
EXPOSE 8100
ENTRYPOINT ["java","-jar","/app.jar"]