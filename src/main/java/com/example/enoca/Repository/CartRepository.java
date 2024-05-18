package com.example.enoca.Repository;

import com.example.enoca.Model.Entity.Cart;
import com.example.enoca.Model.Entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE Cart SET total_price = :cart.price WHERE id = :cart.cartId", nativeQuery = true)
    void updateCart(Cart cart);

    @Transactional
    @Modifying
    @Query(value = """
            INSERT INTO Cart (id, customer_id, cart_price, product_id, product_count)
            VALUES (:cartId, :customerId, (SELECT SUM(cart_price) FROM Cart WHERE customer_id = :customerId), :product.productId, :product.productCount)
            ON CONFLICT (id, customer_id)
            DO UPDATE SET cart_price = cart_price + :product.productCount * :product.productPrice AND product_count = product_count + 1""", nativeQuery = true)
    void addProductToCart(Product product, Integer customerId, Integer cartId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Cart SET product_count = product_count - 1 WHERE product_id = :id AND product_count > 0", nativeQuery = true)
    void removeProductToCart(Integer id);
}
