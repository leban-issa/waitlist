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
    public Optional<Customer> getCustomerById(@PathVariable String id){

        /***
         * Make sure we validate that the id exists if it doesn't then send 400- bad request
         */
        return customerRepository.findById(id);
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@RequestBody Customer customer){
        /***
         *  Requirements:
         *  - API must validate user input.
         *  phoneNumber : 416-244-4444
         *  - Make sure that Id is always null
         *  - Look for edge cases where your api will fail.
         */
        System.out.println(customer);
        customerRepository.save(customer);
        return "Added customer with name : " + customer.getName();
    }

    @GetMapping("/customerCount")
    public long countCustomers() {
        return customerRepository.count();
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteCustomerById(@PathVariable String id){
        System.out.println(id);
        Optional<Customer> c = customerRepository.findById(id);
        // TODO: Implement a check if id exists in the database before deleting and send a BAD_REQUEST http status
        if (c.isPresent()) {
            System.out.println("c = " + c.get());
            customerRepository.delete(c.get());
        }else{
            System.out.println(" ID = "+ id +" is not present");
        }
    }

}
