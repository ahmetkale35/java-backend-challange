package com.example.springboot.enoca_soru_5.repository;

import com.example.springboot.enoca_soru_5.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
}