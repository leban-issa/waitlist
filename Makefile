
build-all:
	docker build -t liben/spring-demo-api .
	docker build -t liben/spring-demo-ui web

build-api-container:
	docker build -t liben/spring-demo-api .

build-ui-container:
	docker build -t liben/spring-demo-ui web

run-ui-container:
	docker run -it -p 3000:3000 liben/spring-demo-ui

run-ui-container:
	docker run -it -p 3000:3000 liben/spring-demo-api

build-docker-compose-up:
	docker-compose up --build