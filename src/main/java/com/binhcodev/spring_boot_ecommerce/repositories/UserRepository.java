package com.binhcodev.spring_boot_ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binhcodev.spring_boot_ecommerce.entities.User;
import java.util.Optional;

/**
 * UserRepository
 */
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByEmail(String email);
}