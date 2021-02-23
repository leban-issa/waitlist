package com.waitlist.information.system.waitlist.controller;

import com.waitlist.information.system.waitlist.model.Restaurant;
import com.waitlist.information.system.waitlist.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Restaurant")
public class RestaurantRestController {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping("/findAllRestaurants")
    public List<Restaurant> getRestaurant(){
        return restaurantRepository.findAll();
    }

    @PostMapping("/addRestaurant")
    public String addRestaurant(@RequestBody Restaurant restaurant){
        restaurantRepository.save(restaurant);
        return "Added restaurant with name : " + restaurant.getName();
    }

    @GetMapping("/findAllRestaurants/{id}")
    public Optional<Restaurant> getRestaurantById(@PathVariable int id){
        return restaurantRepository.findById(id);
    }
}
