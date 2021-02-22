./mvnw package
docker build -t liben/spring-demo .
docker run -p 8080:8080 liben/spring-demo
