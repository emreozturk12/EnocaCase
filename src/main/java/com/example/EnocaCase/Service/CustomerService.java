package com.example.EnocaCase.Service;

import com.example.EnocaCase.Model.Entity.Customer;
import com.example.EnocaCase.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    CustomerRepository customerRepository;

    public Customer addCustomer (Customer customer) {
        return customerRepository.save(customer);
    }
}
