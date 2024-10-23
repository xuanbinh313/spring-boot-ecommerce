package com.binhcodev.spring_boot_ecommerce.dtos.requests;

import lombok.Data;

@Data
public class PaymentRequest {
    private int amount;
    private String currency;
    private String receiptEmail;
}
