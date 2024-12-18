package com.example.springboot.enoca_soru_5.entity;

import jakarta.persistence.Entity;

@Entity
public class Product extends BaseEntity {

    private String name;          // Ürün adı
    private String description;   // Ürün açıklaması
    private Double price;         // Ürün fiyatı
    private Integer stock;        // Stok miktarı

    // Getter ve Setter metodları
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    // Stok kontrolü ve güncelleme metodları
    public boolean isInStock(int quantity) {
        return stock >= quantity;
    }

    public void reduceStock(int quantity) {
        if (isInStock(quantity)) {
            this.stock -= quantity;
        } else {
            throw new RuntimeException("Yetersiz stok!");
        }
    }
}
