K8s sample project with 2 service + Spring Admin 

1. 
config/build_and_push.sh cats-api 1.0.1
config/build_and_push.sh jokes 1.0.0
config/build_and_push.sh spring-admin 1.0.0

2. ####install kind and kubectl

3. ####create cluster
kubectl delete deployments --all
kind delete cluster

kind create cluster --config config/kind-config.yaml

5. ####install ingress plugin
kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/main/deploy/static/provider/kind/deploy.yaml

6. ####check installed plugin
kubectl wait --namespace ingress-nginx \
--for=condition=ready pod \
--selector=app.kubernetes.io/component=controller \
--timeout=90s

7. kubectl apply -f cats-api/k8s
8. kubectl apply -f jokes/k8s
9. kubectl apply -f spring-admin/k8s
10. kubectl apply -f config/ingress.yaml

http://localhost:8888/jokes/random
http://localhost:8888/cats-api/cats

http://localhost:8888/spring-admin/applications