package com.binhcodev.spring_boot_ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binhcodev.spring_boot_ecommerce.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
    
}
