FROM openjdk:21-ea-17-jdk-slim
WORKDIR /app
EXPOSE 8082:8082
COPY target/cart-service.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]