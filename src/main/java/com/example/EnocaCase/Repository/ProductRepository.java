package com.example.EnocaCase.Repository;

import com.example.EnocaCase.Model.Entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findById(Integer id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE product SET name = :product.productName AND stock = :product.stockNumber WHERE id = :product.productId", nativeQuery = true)
    Integer updateProduct(Product product);

    @Modifying
    @Query("DELETE Product WHERE id = :id")
    Integer deleteProduct(Integer id);


}
