FROM maven:3-eclipse-temurin-23

LABEL MAINTAINER="jo yie"
LABEL description="This is VTTP5 Day 12 Workshop"
LABEL name="vttp5_ssf_day12w"

ARG APP_DIR=/APP

WORKDIR ${APP_DIR}

COPY pom.xml .
COPY mvnw .
COPY src src
COPY .mvn .mvn

RUN mvn package -Dmaven.test.skip=true

ENV SERVER_PORT=3000

EXPOSE ${SERVER_PORT}

ENTRYPOINT SERVER_PORT=${SERVER_PORT} java -jar target/vttp5_ssf_day12w-0.0.1-SNAPSHOT.jar