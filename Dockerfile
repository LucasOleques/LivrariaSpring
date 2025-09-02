FROM maven:3.9.2-eclipse-temurin-17 AS build

COPY src /app/src
COPY pom.xml /app

WORKDIR /app
RUN mvn clean install -DskipTests

FROM openjdk:17-jdk-slim

COPY --from=build /app/target/*.jar /app/app.jar

WORKDIR /app

EXPOSE  8080

CMD ["java", "-jar", "app.jar"]