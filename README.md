# Waiting List App

## About the Application

This is a waiting list application that is used to put customers on a waiting list. The framework used was SpringBootand MongoDb to store data of the customers and restaurant. If the database connection works properly you are able to call REST endpoints defined below.


## How to build
To run this application you must do the following below.
* Clone this repository
* Make sure that you are using JDK 11 and have Maven installed.
* Once the application is succesfully build you can run it with one of these two methods. 

```bash
docker build -t liben/spring-demo .
```

or run:

```bash
make build
```
For more info on makefile: https://www.gnu.org/software/make/manual/html_node/Introduction.html


Here are some endpoints you can call:

# Get information about customer, table, and restaurant.

* Get all customers http://localhost:8080/Customer/findAllCustomers. 
* Get customer by id http://localhost:8080/Customer/findAllCustomers/{id}
* Get all tables in restaurant http://localhost:8080/Table/findAllTables
* Get table by id http://localhost:8080/Table/findAllTables/{id}
* Get all restaurants http://localhost:8080/Restaurant/findAllRestaurants
* Get restaurant by id http://localhost:8080/Restaurant/findAllRestaurants/{id}

# To add a new customer, table, or restaurant.

* http://localhost:8080/Customer/addCustomer
* http://localhost:8080/Table/addTable
* http://localhost:8080/Restaurant/addRestaurant

# To view the Swagger2 API docs

* http://localhost:8080/swagger-ui.html#






