./gradlew clean build
docker build . -t trusoff/cats-api:1.0.0
docker push trusoff/cats-api:1.0.0