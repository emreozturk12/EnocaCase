package com.example.EnocaCase.Repository;

import com.example.EnocaCase.Model.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
