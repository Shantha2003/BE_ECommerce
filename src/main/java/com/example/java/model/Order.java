package com.example.java.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

    @Entity
    @Getter
    @Setter
    @ToString
    public class Order {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Double totalAmt;
        private LocalDateTime orderDate;
        private String orderStatus;
        private LocalDateTime deliveryDate;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="created_by",referencedColumnName = "id")
        private User createdBy;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="updated_by",referencedColumnName = "id")
        private User updatedBy;
    }


