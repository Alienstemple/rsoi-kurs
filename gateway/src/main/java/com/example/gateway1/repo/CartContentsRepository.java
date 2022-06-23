package com.example.gateway1.repo;

import com.example.gateway1.model.cart.Cart;
import com.example.gateway1.model.cart.CartContents;
import com.example.gateway1.model.cart.CartContentsKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartContentsRepository extends JpaRepository<CartContents, CartContentsKey> {
    List<CartContents> findByCart(Cart cart);
}
