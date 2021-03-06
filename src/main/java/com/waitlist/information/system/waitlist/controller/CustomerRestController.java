package com.waitlist.information.system.waitlist.controller;



import com.waitlist.information.system.waitlist.model.Customer;
import com.waitlist.information.system.waitlist.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerRestController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/findAllCustomers")
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping("/findAllCustomers/{id}")
    public Optional<Customer> getCustomerById(@PathVariable int id){
        return customerRepository.findById(id);
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@RequestBody Customer customer){
        // TODO: Return metrics about how many customers where added
        // Research Prometheus metrics
        System.out.println(customer);
        customerRepository.save(customer);
        return "Added customer with name : " + customer.getName();
    }

    @GetMapping("/customerCount")
    public long countCustomers() {
        return customerRepository.count();
    }
}
