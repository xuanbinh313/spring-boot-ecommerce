package com.binhcodev.spring_boot_ecommerce.services;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.binhcodev.spring_boot_ecommerce.dtos.requests.UserRequestDto;
import com.binhcodev.spring_boot_ecommerce.entities.User;
import com.binhcodev.spring_boot_ecommerce.repositories.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User save(UserRequestDto user) {
        Optional<User> existUser = userRepository.findByEmail(user.getEmail());
        if (existUser.isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }
        User newUser = User.builder()
            .email(user.getEmail())
            .password(passwordEncoder.encode(user.getPassword()))
            .fullName(user.getFullName())
            .build();
        return userRepository.save(newUser);
    }
}
