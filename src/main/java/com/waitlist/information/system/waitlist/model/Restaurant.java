package com.waitlist.information.system.waitlist.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Document(collection = "Restaurant")
@RequestMapping("/api")
public class Restaurant {
    @Id
    private String id;

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotEmpty(message = "Phone number cannot be empty")
    @Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
            message = "Phone number is invalid")
    private String phoneNumber;

    @NotEmpty(message = "Address cannot be empty")
    private String address;

    @NotEmpty(message = "Password cannot be empty")
    private String password;
    //change address to object

    /**
     * Constructor for restaurant.
     * @param id restaurant
     * @param name restaurant
     * @param phoneNumber restaurant
     * @param address restaurant
     * @param password restaurant
     */
    public Restaurant(String id, String name, String phoneNumber, String address, String password) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Restaurant{"
            +
                "id=" + id
            +
                ", name='" + name + '\''
            +
                ", phoneNumber=" + phoneNumber
            +
                ", address='" + address + '\''
            +
                '}';
    }
}
