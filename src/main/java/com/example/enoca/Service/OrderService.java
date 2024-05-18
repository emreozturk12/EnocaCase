package com.example.enoca.Service;

import com.example.enoca.Model.Entity.Cart;
import com.example.enoca.Model.Entity.OldPrices;
import com.example.enoca.Model.Entity.Order;
import com.example.enoca.Model.Entity.Product;
import com.example.enoca.Repository.OldPricesRepository;
import com.example.enoca.Repository.OrderRepository;
import com.example.enoca.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    OrderRepository orderRepository;
    ProductRepository productRepository;
    OldPricesRepository oldPricesRepository;

    public void placeOrder(Cart cart) {

        Order order = new Order();
        order.setOrderPrice(cart.getCartPrice());
        order.setOrderDate(LocalDateTime.now());
        order.setCustomerId(cart.getCustomerId());
        order.setId(UUID.randomUUID());

        orderRepository.save(order);

        Optional<Product> product = productRepository.findById(cart.getProductId());

        OldPrices oldPrices = new OldPrices();
        oldPrices.setOrderId(order.getId());
        oldPrices.setCustomerId(cart.getCustomerId());
        oldPrices.setProductCount(cart.getProductCount());
        oldPrices.setId(UUID.randomUUID());
        oldPrices.setProductId(cart.getProductId());
        oldPrices.setProductPrice(product.get().getProductPrice());

        oldPricesRepository.save(oldPrices);

    }

    public Order getOrderForCode(UUID id) {
        return orderRepository.findById(id);
    }
    public Pageable getAllOrdersForCustomer(Integer id) {
        return orderRepository.getAllOrdersForCustomer(id);
    }
}
