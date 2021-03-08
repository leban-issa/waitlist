package com.waitlist.information.system.waitlist.repository;

import com.waitlist.information.system.waitlist.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
