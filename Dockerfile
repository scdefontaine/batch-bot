#  Build stage
FROM maven:3.8.4-openjdk-17 as build
COPY . .
RUN mvn clean package

# Run stage
FROM openjdk:17
COPY --from=build target/batch-bot-0.0.1-SNAPSHOT.jar batch-bot.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/batch-bot.jar"]