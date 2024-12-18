package com.example.springboot.enoca_soru_5.repository;

import com.example.springboot.enoca_soru_5.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    // Müşteri ID'ye göre sepet bul
    Optional<Cart> findByCustomerId(Long customerId);

    // Tüm sepetleri listele
    List<Cart> findAll();
}

