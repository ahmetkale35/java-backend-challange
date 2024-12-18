package com.example.springboot.enoca_soru_5.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer; // Siparişi veren müşteri

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderDetails> orderDetailsList; // Sipariş içindeki ürün detayları

    private Double totalPrice; // Siparişin toplam tutarı

    // Getter ve Setter metodları
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    // Siparişin toplam tutarını hesaplamak için metod
    public void calculateTotalPrice() {
        double total = 0.0;
        for (OrderDetails details : orderDetailsList) {
            total += details.getProductPrice() * details.getQuantity();
        }
        this.totalPrice = total;
    }
}
