FROM alpine:3.15

RUN apk add openjdk11
COPY ../cat-api/build/libs/cats-api.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
