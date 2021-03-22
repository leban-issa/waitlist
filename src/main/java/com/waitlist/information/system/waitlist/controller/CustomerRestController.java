package com.waitlist.information.system.waitlist.controller;


import com.waitlist.information.system.waitlist.model.Customer;
import com.waitlist.information.system.waitlist.model.Restaurant;
import com.waitlist.information.system.waitlist.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;


import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/Customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerRestController {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerRestController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("/addCustomer")
    public Customer addCustomer(@Valid @RequestBody Customer customer) {
        System.out.println(customer);
        return customerRepository.save(customer);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return errors;
    }

    @GetMapping("/findAllCustomers")
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/findAllCustomers/{id}")
    public Optional<Customer> getCustomerById(@PathVariable String id) {
        Optional<Customer> customer = customerRepository.findById(id);
        System.out.println(customer);
        if (!customer.isPresent() || customer == null) {
            System.out.println("Smoke: customer is present");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            System.out.println("Smoke: customer not present");
        }
        return customer;
    }

    @PutMapping("/findAllCustomers/{id}")
    public Customer updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer c = optionalCustomer.get();
            if (customer.getEmail() != null)
                c.setEmail(customer.getEmail());
            if (customer.getName() != null)
                c.setName(customer.getName());
            if (customer.getPartySize() != 0)
                c.setPartySize(customer.getPartySize());
            if (customer.getPhone() != null)
                c.setPhone(customer.getPhone());
            return customerRepository.save(c);
        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/customerCount")
    public long countCustomers() {
        return customerRepository.count();
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteCustomerById(@PathVariable String id) {
        System.out.println(id);
        Optional<Customer> c = customerRepository.findById(id);
        if (c.isPresent()) {
            System.out.println("c = " + c.get());
            customerRepository.delete(c.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
