## back build
FROM eclipse-temurin:17-jdk-alpine as build-back

WORKDIR /workspace/back

COPY back/pom.xml .
COPY back/src src

RUN apk add maven
RUN mvn clean package -Dmaven.test.skip=true

## front build
FROM node:18-alpine as build-front

WORKDIR /workspace/front

RUN npm install -g @angular/cli

COPY front .

RUN npm install --force
RUN ng build

## container specs
FROM openjdk:17-jdk-alpine as server

ARG MERCADO_PAGO_ACCESS_TOKEN

COPY --from=build-back /workspace/back/target/back-*-SNAPSHOT.jar app.jar
COPY --from=build-front /workspace/front/dist/front/browser static

ENTRYPOINT ["java","-jar","/app.jar"]