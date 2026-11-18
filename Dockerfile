FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /workspace
COPY services/crm-service/pom.xml services/crm-service/pom.xml
COPY services/crm-service/src services/crm-service/src
RUN mvn -q -f services/crm-service/pom.xml -DskipTests package
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /workspace/services/crm-service/target/crm-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
