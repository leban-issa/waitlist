from locust import HttpUser, TaskSet, task
import json
class UserBehavior(TaskSet):


    @task
    def create_customer(self):
        headers = {'content-type': 'application/json'}
        self.client.post( "/Customer/addCustomer", data = json.dumps({
            "name":"John",
            "email":"john@gmail.com",
            "phone":"416-555-5555",
            "id": "",
            "partySize": 2}),
                          headers = headers)


    @task(1)
    def get_customers(self):
        self.client.get( "/Customer/findAllCustomers")

    @task(2)
    def create_restaurant(self):
        headers = {'content-type': 'application/json'}
        self.client.post( "/Restaurant/addRestaurant", data = json.dumps({
            "name":"McDonalds",
            "password":"password",
            "phoneNumber":"416-555-5555",
            "id": "",
            "address": "123 Street"}),
                          headers = headers)

    @task(3)
    def get_restaurant(self):
        self.client.get( "/Restaurant/findAllRestaurants")


    @task(4)
    def create_table(self):
        headers = {'content-type': 'application/json'}
        self.client.post( "/Table/addTable", data = json.dumps({
            "location":"Private Room",
            "size":6,
            "id": ""}),
                          headers = headers)


    @task(5)
    def get_tables(self):
        self.client.get( "/Table/findAllTables")


class WebsiteUser(HttpUser):
    tasks = [UserBehavior]
    min_wait = 5000
    max_wait = 9000