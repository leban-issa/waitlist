package com.waitlist.information.system.waitlist.service;

import com.waitlist.information.system.waitlist.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer findByCustomerName(String name);
    Customer findByEmail(String email);
    Customer findByNumber(String number);
    Customer findById(String id);
    void deleteCustomerById(String id);
    List<Customer> findAll();
}
