#base image: linux alpine os with open jdk 21
FROM maven:3.9.8-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml ./
COPY src ./src

RUN mvn clean package

FROM eclipse-temurin:21-alpine

#copy jar from local into docker image
COPY --from=build /app/target/notificationservice-0.0.1-SNAPSHOT.jar notificationservice-0.0.1-SNAPSHOT.jar

# Expose port
EXPOSE 8088

#command line to run jar
ENTRYPOINT ["java","-jar","/notificationservice-0.0.1-SNAPSHOT.jar"]
