package com.example.enoca.Service;

import com.example.enoca.Model.Entity.Customer;
import com.example.enoca.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    CustomerRepository customerRepository;

    public Customer addCustomer (Customer customer) {
        return customerRepository.save(customer);
    }
}
