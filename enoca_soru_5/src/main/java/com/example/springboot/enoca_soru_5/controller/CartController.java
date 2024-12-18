package com.example.springboot.enoca_soru_5.controller;

import com.example.springboot.enoca_soru_5.entity.Cart;
import com.example.springboot.enoca_soru_5.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{customerId}")
    public ResponseEntity<Cart> getCartByCustomerId(@PathVariable Long customerId) {
        return ResponseEntity.ok(cartService.getCartByCustomerId(customerId));
    }

    @PostMapping("/{customerId}/add")
    public ResponseEntity<Cart> addProductToCart(
            @PathVariable Long customerId,
            @RequestParam Long productId,
            @RequestParam int quantity) {
        return ResponseEntity.ok(cartService.addProductToCart(customerId, productId, quantity));
    }

    @DeleteMapping("/{customerId}/remove")
    public ResponseEntity<Cart> removeProductFromCart(
            @PathVariable Long customerId,
            @RequestParam Long productId) {
        return ResponseEntity.ok(cartService.removeProductFromCart(customerId, productId));
    }
}

