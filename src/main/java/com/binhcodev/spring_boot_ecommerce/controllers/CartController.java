package com.binhcodev.spring_boot_ecommerce.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binhcodev.spring_boot_ecommerce.dtos.requests.CartDto;
import com.binhcodev.spring_boot_ecommerce.entities.Cart;
import com.binhcodev.spring_boot_ecommerce.services.CartService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("/{id}")
    public ResponseEntity<Cart> findOne(@PathVariable Long id) {
        Cart cart = cartService.getCartById(id);
        return ResponseEntity.ok(cart);
    }

    @PostMapping
    public ResponseEntity<Cart> create(@RequestBody CartDto cart) {
        Cart newCart = cartService.saveCart(cart);
        return ResponseEntity.status(201).body(newCart);
    }

}
