package com.example.springboot.enoca_soru_5.entity;

import jakarta.persistence.*;

@Entity
public class OrderDetails extends BaseEntity {

    private Long productId;       // Ürünün ID'si
    private String productName;   // Ürünün adı
    private Double productPrice;  // Sipariş anındaki ürün fiyatı
    private Integer quantity;     // Sipariş edilen miktar

    // Getter ve Setter metodları
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    // Toplam fiyatı hesaplamak için metod
    public Double getTotalPrice() {
        return productPrice * quantity;
    }
}
