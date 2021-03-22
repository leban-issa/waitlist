package com.waitlist.information.system.waitlist.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Document(collection = "Customer")
public class Customer {
    @Id
    private String id;

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotEmpty(message = "Email cannot be empty")
    @Email
    private String email;

    @NotEmpty(message = "Phone number cannot be empty")
    @Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
            message = "Phone number is invalid")
    private String phone;

    @NotNull(message = "Party size cannot be empty")
    @Min(value = 1, message = "Party size cannot be less then 1")
    private int partySize;

    /**
     * Constrctor for customer.
     * @param name of customer
     * @param email of customer
     * @param phone of customer
     * @param id of customer
     * @param partySize of customer
     */
    public Customer(String name, String email, String phone, String id, int partySize) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.id = id;
        this.partySize = partySize;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPartySize() {
        return partySize;
    }

    public void setPartySize(int partySize) {
        this.partySize = partySize;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{"
            +
                "id=" + id
            +
                ", name='" + name + '\''
            +
                ", email='" + email + '\''
            +
                ", number='" + phone + '\''
            +
                ", partySize=" + partySize
            +
                '}';
    }
}
