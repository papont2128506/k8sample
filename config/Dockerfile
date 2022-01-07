FROM alpine:3.15

RUN apk add openjdk11
COPY build/libs/app.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
