package com.binhcodev.spring_boot_ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binhcodev.spring_boot_ecommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
