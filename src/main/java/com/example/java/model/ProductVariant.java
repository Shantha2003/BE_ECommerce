package com.example.java.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ProductVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "prodId")
    private Product product;

    private String size;
    private String color;
    private int stockQuantity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "createdBy")
    private User createdBy;

    @ManyToOne
    @JoinColumn(name = "updatedBy")
    private User updatedBy;
}
