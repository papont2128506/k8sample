cp config/Dockerfile $1/Dockerfile
cd $1

./gradlew clean build

docker build . -t trusoff/$1:$2
docker push trusoff/$1:$2

rm Dockerfile