package com.waitlist.information.system.waitlist.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "Customer")
public class Customer {
    @Id
    private int id;
    private String name;
    private String email;
    private String number;

    public Customer() {
    }

    public Customer(String name, String email, String number, int id) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", number=" + number +
                ", id='" + id + '\'' +
                '}';
    }
}
