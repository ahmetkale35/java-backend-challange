package com.example.springboot.enoca_soru_5.controller;

import com.example.springboot.enoca_soru_5.entity.Order;
import com.example.springboot.enoca_soru_5.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{customerId}/place")
    public ResponseEntity<Order> placeOrder(@PathVariable Long customerId) {
        return ResponseEntity.ok(orderService.placeOrder(customerId));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<List<Order>> getOrdersForCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(orderService.getOrdersForCustomer(customerId));
    }
}

