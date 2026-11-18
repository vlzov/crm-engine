FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/customer-service-3.4.5.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
