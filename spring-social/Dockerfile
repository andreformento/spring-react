# syntax = docker/dockerfile:experimental

FROM maven:3.6.3-openjdk-15 AS builder

WORKDIR /app

COPY pom.xml ./

COPY src ./src
RUN --mount=type=cache,target=/root/.m2 mvn package

FROM openjdk:15-jdk

WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
