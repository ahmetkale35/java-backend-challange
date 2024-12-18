package com.example.springboot.enoca_soru_5.service;

import com.example.springboot.enoca_soru_5.entity.Cart;
import com.example.springboot.enoca_soru_5.entity.Product;
import com.example.springboot.enoca_soru_5.repository.CartRepository;
import com.example.springboot.enoca_soru_5.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public Cart getCartByCustomerId(Long customerId) {
        return cartRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Sepet bulunamadı!"));
    }

    public Cart addProductToCart(Long customerId, Long productId, int quantity) {
        Cart cart = getCartByCustomerId(customerId);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Ürün bulunamadı!"));

        if (!product.isInStock(quantity)) {
            throw new RuntimeException("Yetersiz stok!");
        }

        cart.getProductQuantities().merge(productId, quantity, Integer::sum);
        product.reduceStock(quantity);
        cart.setTotalPrice(calculateTotalPrice(cart));
        productRepository.save(product);
        return cartRepository.save(cart);
    }

    public Cart removeProductFromCart(Long customerId, Long productId) {
        Cart cart = getCartByCustomerId(customerId);

        if (cart.getProductQuantities().containsKey(productId)) {
            cart.getProductQuantities().remove(productId);
            cart.setTotalPrice(calculateTotalPrice(cart));
            return cartRepository.save(cart);
        }

        throw new RuntimeException("Ürün sepette bulunamadı!");
    }

    private Double calculateTotalPrice(Cart cart) {
        return cart.getProductQuantities().entrySet().stream()
                .mapToDouble(entry -> {
                    Product product = productRepository.findById(entry.getKey())
                            .orElseThrow(() -> new RuntimeException("Ürün bulunamadı!"));
                    return product.getPrice() * entry.getValue();
                }).sum();
    }
}

