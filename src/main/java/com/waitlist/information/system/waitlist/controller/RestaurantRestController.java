package com.waitlist.information.system.waitlist.controller;

import com.waitlist.information.system.waitlist.model.Restaurant;
import com.waitlist.information.system.waitlist.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;


@RestController
@RequestMapping("/Restaurant")
@CrossOrigin(origins = "http://localhost:3000")
public class RestaurantRestController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    /**
     * Add a restaurant.
     *
     * @param restaurant gives information about the restaurant
     * @return restaurant
     */
    @PostMapping("/addRestaurant")
    public Restaurant addRestaurant(@Valid @RequestBody Restaurant restaurant){
        return restaurantRepository.save(restaurant);

    }

    /**
     * Gets the errors when posting a invalid restaurant.
     * @param ex gives not valid exception
     * @return handle method exception
     * @throws Exception when user input is invalid
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
            errors.put(error.getField(), error.getDefaultMessage()));

        return errors;
    }

    /**
     * Find all restaurants.
     *
     * @return all the restaurants
     */
    @GetMapping("/findAllRestaurants")
    public List<Restaurant> getRestaurant(){
        return restaurantRepository.findAll();
    }

    /**
     *Gets all restaurant by id.
     * @param id is the restaurant id
     * @return restaurant
     */
    @GetMapping("/findAllRestaurants/{id}")
    public Optional<Restaurant> getRestaurantById(@PathVariable String id){
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        if(!restaurant.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return restaurant;
    }
}
