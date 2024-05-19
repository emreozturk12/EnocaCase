package com.example.EnocaCase.Service;

import com.example.EnocaCase.Model.Entity.Cart;
import com.example.EnocaCase.Model.Entity.OldPrices;
import com.example.EnocaCase.Model.Entity.Order;
import com.example.EnocaCase.Model.Entity.Product;
import com.example.EnocaCase.Repository.OldPricesRepository;
import com.example.EnocaCase.Repository.OrderRepository;
import com.example.EnocaCase.Repository.ProductRepository;
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
