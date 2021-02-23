package com.waitlist.information.system.waitlist.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Restaurant")
public class Restaurant {
    @Id
    private int id;
    private String name;
    private int lineLength;

    public Restaurant() {
    }

    public Restaurant(int id, String name, int lineLength) {
        this.id = id;
        this.name = name;
        this.lineLength = lineLength;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLineLength() {
        return lineLength;
    }

    public void setLineLength(int lineLength) {
        this.lineLength = lineLength;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lineLength=" + lineLength +
                '}';
    }
}
