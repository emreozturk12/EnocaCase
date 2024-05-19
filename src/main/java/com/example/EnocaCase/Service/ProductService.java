package com.example.EnocaCase.Service;

import com.example.EnocaCase.Model.Entity.Product;
import com.example.EnocaCase.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    ProductRepository productRepository;

    public Optional<Product> getProduct(Integer id) {
        return productRepository.findById(id);
    }
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    public Integer updateProduct(Product product) {
        return productRepository.updateProduct(product);
    }
    public Integer deleteProduct(Integer id) {
        return productRepository.deleteProduct(id);
    }

}
