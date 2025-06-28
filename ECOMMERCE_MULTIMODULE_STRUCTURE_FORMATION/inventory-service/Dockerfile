FROM openjdk:21-ea-17-jdk-slim
WORKDIR /app
EXPOSE 8081:8081
COPY target/inventory-service.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
