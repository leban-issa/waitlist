package com.waitlist.information.system.waitlist.controller;


import com.waitlist.information.system.waitlist.model.Customer;
import com.waitlist.information.system.waitlist.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@RequestMapping("/Customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerRestController {

    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerRestController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("/addCustomer")
    public Customer addCustomer(@Valid @RequestBody Customer customer) {
        System.out.println(customer);
        return customerRepository.save(customer);
    }

    /**
     * Gets the errors when posting a invalid customer.
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

    @GetMapping("/findAllCustomers")
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    /**
     *Gets all customers by id.
     * @param id is the customers id
     * @return customer
     */
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

    /**
     *Updates a customer by id.
     * @param id customers id that is in the path variable
     * @return customer
     */
    @PutMapping("/findAllCustomers/{id}")
    public Customer updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer cust = optionalCustomer.get();
            if (customer.getEmail() != null) {
                cust.setEmail(customer.getEmail());
            }
            if (customer.getName() != null) {
                cust.setName(customer.getName());
            }
            if (customer.getPartySize() != 0) {
                cust.setPartySize(customer.getPartySize());
            }
            if (customer.getPhone() != null) {
                cust.setPhone(customer.getPhone());
            }
            return customerRepository.save(cust);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/customerCount")
    public long countCustomers() {
        return customerRepository.count();
    }

    /**
     *Deletes a customer by id.
     * @param id customer id
     */
    @DeleteMapping("/deleteById/{id}")
    public void deleteCustomerById(@PathVariable String id) {
        System.out.println(id);
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            System.out.println("c = " + customer.get());
            customerRepository.delete(customer.get());
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
