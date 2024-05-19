package com.example.EnocaCase.Repository;

import com.example.EnocaCase.Model.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order findById(UUID id);

    @Query(value = "SELECT * FROM Order WHERE customer_id = :id", nativeQuery = true)
    Pageable getAllOrdersForCustomer(Integer id);
}
