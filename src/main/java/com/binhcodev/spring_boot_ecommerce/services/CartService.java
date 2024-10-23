package com.binhcodev.spring_boot_ecommerce.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.binhcodev.spring_boot_ecommerce.dtos.requests.CartDto;
import com.binhcodev.spring_boot_ecommerce.entities.Cart;
import com.binhcodev.spring_boot_ecommerce.entities.Product;
import com.binhcodev.spring_boot_ecommerce.entities.User;
import com.binhcodev.spring_boot_ecommerce.repositories.CartRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final UserService userService;
    private final ProductService productService;
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Cart getCartById(Long id) {
        return cartRepository.findById(id).orElseThrow();
    }

    public Cart saveCart(CartDto cartDto) {
        User user = userService.getCurrentUser();
        List<Product> products = productService.getProductsByIds(cartDto.getItems());
        Double total = products.stream().map(product -> product.getPrice().doubleValue()).mapToDouble(Double::doubleValue).sum();
        Cart cart = Cart.builder()
                .items(products)
                .total(total)
                .user(user)
                .build();
        return cartRepository.save(cart);
    }

    public void deleteCart(Long id) {
        Cart existCart = cartRepository.findById(id).orElse(null);
        if (existCart == null) {
            throw new RuntimeException("Cart not found");
        }
        cartRepository.deleteById(id);
    }

    public Cart updateCart(Long id, Cart cart) {
        Cart existingCart = cartRepository.findById(id).orElse(null);
        if (existingCart == null) {
            return null;
        }
        existingCart.setItems(cart.getItems());
        existingCart.setTotal(cart.getTotal());
        return cartRepository.save(existingCart);
    }
}
