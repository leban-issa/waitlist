# Waiting List API

## About the Application

This is a waiting list application that is used to put customers of a restaurant on a waiting list. I used the java framework Spring Boot and to store the data of the customers and restaurant I used MongoDB. Several endpoints have been created and all the API's are documented using Swagger2 which you can find below. 


## How to build
To run this application you must do the following below.
* Clone this repository
* Make sure that you are using JDK 11, 13, or 15 and have Maven installed.
* Once the application is succesfully build you can run it with one of these two methods. 

```bash
docker build -t liben/spring-demo .
```

or run:

```bash
mvn springboot:run
```

## How to test
There are two tests in this application one that tests all the endpoints in the backend called Waitlist App Tests and another test called Integration Test that tests both the front end and backend. To run both tests you would first need the front end running for the Integration tests the command to run the front end is below and once the that is done you will be able to run both tests together using another command below.

to run the front end:
```bash
npm start
```
run both tests together:
```bash
mvn test
```

## Load Testing
Load testing is set up using Locust.
To have locust running ensure that python or python3 is installed on your machine and that pip is installed as well.
Once those are installed you must then install locust using the command below.

To install locust
```bash
pip install locust
```
To run locust
```bash
locust -f loadTesting.py --host=http://localhost:8080
```

## Configure Mongo Atlas Database
To set up your own database you must first create an Atlas account.
Once that is done create a cluster select your preferred cloud provider and region enter your cluster name and deploy that cluster.
The next step is to add your current IP address to set up a connection.
Then create a new username and password to access your database and collections to your cluster.
After that is all done download MongoDB Compass which allows you to connect to your database and create new collections.

For a more detailed explanation follow this link https://docs.atlas.mongodb.com/getting-started/.

# Here are some endpoints you can call:

## Get information about customer, table, and restaurant.

* Get all customers http://localhost:8080/Customer/findAllCustomers. 
* Get customer by id http://localhost:8080/Customer/findAllCustomers/{id}
* Get all tables in restaurant http://localhost:8080/Table/findAllTables
* Get table by id http://localhost:8080/Table/findAllTables/{id}
* Get all restaurants http://localhost:8080/Restaurant/findAllRestaurants
* Get restaurant by id http://localhost:8080/Restaurant/findAllRestaurants/{id}
* Get number of customers http://localhost:8080/Customer/customerCount

## To add a new customer, table, or restaurant.

* http://localhost:8080/Customer/addCustomer
* http://localhost:8080/Table/addTable
* http://localhost:8080/Restaurant/addRestaurant

## To view the Swagger2 API docs

* http://localhost:8080/swagger-ui.html#






