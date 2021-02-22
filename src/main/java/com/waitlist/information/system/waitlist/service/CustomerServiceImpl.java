//package com.waitlist.information.system.waitlist.service;
//
//import com.waitlist.information.system.waitlist.model.Customer;
//import com.waitlist.information.system.waitlist.repository.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//
//@Service
//public class CustomerServiceImpl implements CustomerService {
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @Override
//    public Customer findByCustomerName(String name) {
//        return customerRepository.findByCustomerName(name);
//    }
//
//    @Override
//    public Customer findByEmail(String email) {
//        return customerRepository.findByEmail(email);
//    }
//
//    @Override
//    public Customer findByNumber(String number) {
//        return customerRepository.findByNumber(number);
//    }
//
//    @Override
//    public void deleteCustomerById(String id) {
//        customerRepository.deleteById(id);
//    }
//
//    @Override
//    public List<Customer> findAll() {
//        return customerRepository.findAll();
//    }
//
//}
