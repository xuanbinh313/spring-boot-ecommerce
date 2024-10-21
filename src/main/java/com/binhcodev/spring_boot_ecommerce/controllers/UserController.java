package com.binhcodev.spring_boot_ecommerce.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/auth/users")
public class UserController {
    @GetMapping 
    public String getUsers() {
        return "Get all users";
    }
    
}
