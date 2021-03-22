package com.waitlist.information.system.waitlist.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Document(collection = "Table")
public class Table {
    @Id
    private String id;

    @NotNull(message = "Party size cannot be empty")
    @Min(value = 1, message = "Size cannot be less then 1")
    private int size;

    @NotEmpty(message = "Location cannot be empty")
    private String location;


    /**
     * Constructor for table.
     * @param id for table
     * @param size for table
     * @param location for table
     */
    public Table(String id, int size, String location) {
        this.id = id;
        this.size = size;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
