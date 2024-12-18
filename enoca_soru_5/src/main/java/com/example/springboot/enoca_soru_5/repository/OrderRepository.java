package com.example.springboot.enoca_soru_5.repository;

import com.example.springboot.enoca_soru_5.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Müşteri ID'ye göre tüm siparişleri getir
    List<Order> findByCustomerId(Long customerId);

    // Sipariş koduna göre sipariş bul (id üzerinden örneklenmiştir)
    Optional<Order> findById(Long orderId);
}
