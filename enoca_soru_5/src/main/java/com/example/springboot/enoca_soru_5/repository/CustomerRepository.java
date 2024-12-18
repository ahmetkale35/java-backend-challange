package com.example.springboot.enoca_soru_5.repository;

import com.example.springboot.enoca_soru_5.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Email'e göre müşteri bul
    Optional<Customer> findByEmail(String email);

    // İsme göre müşteri ara
    List<Customer> findByNameContainingIgnoreCase(String name);
}

