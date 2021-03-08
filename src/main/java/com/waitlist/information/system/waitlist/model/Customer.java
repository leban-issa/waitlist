package com.waitlist.information.system.waitlist.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "Customer")
public class Customer {
    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private int partySize;

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

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public int getPartySize() { return partySize; }

    public void setPartySize(int partySize) { this.partySize = partySize; }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", number='" + phone + '\'' +
                ", partySize=" + partySize +
                '}';
    }
}
