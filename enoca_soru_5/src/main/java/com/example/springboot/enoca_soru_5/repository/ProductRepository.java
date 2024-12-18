package com.example.springboot.enoca_soru_5.repository;

import com.example.springboot.enoca_soru_5.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Stokta olan ürünleri getir
    List<Product> findByStockGreaterThan(int stock);

    // İsme göre ürün ara
    List<Product> findByNameContainingIgnoreCase(String name);

    // Belirli bir fiyat aralığındaki ürünleri getir
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
}

