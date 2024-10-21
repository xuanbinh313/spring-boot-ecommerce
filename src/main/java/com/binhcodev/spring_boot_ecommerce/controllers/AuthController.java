package com.binhcodev.spring_boot_ecommerce.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binhcodev.spring_boot_ecommerce.dtos.requests.UserRequestDto;
import com.binhcodev.spring_boot_ecommerce.services.UserService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody UserRequestDto entity) {
        userService.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build(); 
    }
    
}
