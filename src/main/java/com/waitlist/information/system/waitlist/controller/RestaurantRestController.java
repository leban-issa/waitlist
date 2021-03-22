package com.waitlist.information.system.waitlist.controller;

import com.waitlist.information.system.waitlist.model.Restaurant;
import com.waitlist.information.system.waitlist.model.Table;
import com.waitlist.information.system.waitlist.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/Restaurant")
@CrossOrigin(origins = "http://localhost:3000")
public class RestaurantRestController {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @PostMapping("/addRestaurant")
    public Restaurant addRestaurant(@Valid @RequestBody Restaurant restaurant){
        return restaurantRepository.save(restaurant);

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return errors;
    }

    @GetMapping("/findAllRestaurants")
    public List<Restaurant> getRestaurant(){
        return restaurantRepository.findAll();
    }

    @GetMapping("/findAllRestaurants/{id}")
    public Optional<Restaurant> getRestaurantById(@PathVariable String id){
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        if(!restaurant.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return restaurant;
    }
}
