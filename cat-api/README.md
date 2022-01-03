#Cat-api

###start db service:
    docker-compose -f compose-env.yaml up -d

###build docker image
chmod +x build_and_push.sh

###start docker container
~~docker run -ti --rm trusoff/cats-api:1.0.0~~

docker run -ti --rm -e DATASOURCE-HOST=192.168.0.130 trusoff/cats-api:1.0.0

###drop docker container
docker rmi trusoff/cats-api:1.0.0

###push image
docker push trusoff/cats-api:1.0.0

###pull image
docker push trusoff/cats-api:1.0.0

### k8s 

1.install kind and kubectl

2.kind create cluster --config kind-config.yaml

3. install ingress plugin
kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/main/deploy/static/provider/kind/deploy.yaml

4.check installed plugin
kubectl wait --namespace ingress-nginx \
--for=condition=ready pod \
--selector=app.kubernetes.io/component=controller \
--timeout=90s

5. apply deployment config
kubectl apply -f k8s/deployment.yaml

6. kubectl get pods

7. kubectl get pods --watch

8. port forward
   kubectl port-forward cats-api-7756755989-4slqx 8899:8080

9. http://localhost:8899/cats

10. apply service config
kubectl apply -f k8s/service.yaml

11.kubectl get service

12. kubectl apply -f k8s/ingress.yaml
 
14. Проверка запуска кластера через ingress c балансированием нагрузки
    http://localhost:8888/cats-api/cats