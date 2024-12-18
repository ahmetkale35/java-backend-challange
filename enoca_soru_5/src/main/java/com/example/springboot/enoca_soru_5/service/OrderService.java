package com.example.springboot.enoca_soru_5.service;

import com.example.springboot.enoca_soru_5.entity.*;
import com.example.springboot.enoca_soru_5.repository.OrderRepository;
import com.example.springboot.enoca_soru_5.repository.ProductRepository;
import com.example.springboot.enoca_soru_5.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public Order placeOrder(Long customerId) {
        Cart cart = cartRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Sepet bulunamadı!"));

        if (cart.getProductQuantities().isEmpty()) {
            throw new RuntimeException("Sepet boş, sipariş verilemez!");
        }

        Order order = new Order();
        order.setCustomer(cart.getCustomer());
        order.setTotalPrice(cart.getTotalPrice());

        List<OrderDetails> detailsList = new ArrayList<>();
        cart.getProductQuantities().forEach((productId, quantity) -> {
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Ürün bulunamadı!"));

            OrderDetails details = new OrderDetails();
            details.setProductId(productId);
            details.setProductName(product.getName());
            details.setProductPrice(product.getPrice());
            details.setQuantity(quantity);

            detailsList.add(details);
        });

        order.setOrderDetailsList(detailsList);
        cart.getProductQuantities().clear();
        cart.setTotalPrice(0.0);

        cartRepository.save(cart);
        return orderRepository.save(order);
    }

    public List<Order> getOrdersForCustomer(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }
}

