package com.waitlist.information.system.waitlist.repository;

import com.waitlist.information.system.waitlist.model.Table;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TableRepository extends MongoRepository<Table, Integer> {

}
