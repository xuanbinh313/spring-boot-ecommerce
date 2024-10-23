package com.binhcodev.spring_boot_ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binhcodev.spring_boot_ecommerce.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findByUserEmail(String userEmail);
}
