package com.binhcodev.spring_boot_ecommerce.dtos.requests;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CartDto {
    private List<Long> items;
}
