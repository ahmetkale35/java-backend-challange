package com.example.springboot.enoca_soru_5.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "name", nullable = false)
    private String name;



    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "address")
    private String address;


    public Customer(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;

    }
}