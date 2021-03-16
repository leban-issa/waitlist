package com.waitlist.information.system.waitlist.repository;

import com.waitlist.information.system.waitlist.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestaurantRepository extends MongoRepository<Restaurant, String> {

}
