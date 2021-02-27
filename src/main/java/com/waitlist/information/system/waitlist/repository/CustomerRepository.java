package com.waitlist.information.system.waitlist.repository;

import com.waitlist.information.system.waitlist.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, Integer> {

}
