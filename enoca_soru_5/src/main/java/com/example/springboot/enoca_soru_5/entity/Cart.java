package com.example.springboot.enoca_soru_5.entity;

import jakarta.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Cart extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ElementCollection
    @CollectionTable(name = "cart_products", joinColumns = @JoinColumn(name = "cart_id"))
    @MapKeyColumn(name = "product_id")
    @Column(name = "quantity")
    private Map<Long, Integer> productQuantities = new HashMap<>(); // Ürün ID ve miktar ilişkisi

    private Double totalPrice; // Toplam fiyat

    // Getter ve Setter metodları
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Map<Long, Integer> getProductQuantities() {
        return productQuantities;
    }

    public void setProductQuantities(Map<Long, Integer> productQuantities) {
        this.productQuantities = productQuantities;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    // Sepete ürün eklemek için metod
    public void addProduct(Long productId, Integer quantity) {
        this.productQuantities.put(productId, this.productQuantities.getOrDefault(productId, 0) + quantity);
    }

    // Sepetten ürün çıkarmak için metod
    public void removeProduct(Long productId) {
        this.productQuantities.remove(productId);
    }

    // Toplam fiyatı hesaplamak için metod
    public void calculateTotalPrice(Map<Long, Product> productCatalog) {
        double total = 0.0;
        for (Map.Entry<Long, Integer> entry : productQuantities.entrySet()) {
            Long productId = entry.getKey();
            Integer quantity = entry.getValue();
            Product product = productCatalog.get(productId);
            if (product != null) {
                total += product.getPrice() * quantity;
            }
        }
        this.totalPrice = total;
    }
}
