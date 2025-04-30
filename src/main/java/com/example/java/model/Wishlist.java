package com.example.java.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

    @Entity
    @Table(name = "wishlist")
    @Getter
    @Setter
    @ToString
    public class Wishlist {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "userId")
        private Long user;

        @ManyToOne
        @JoinColumn(name = "productId")
        private Product product;


        private LocalDateTime addedAt;
        private int quantity;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="created_by",referencedColumnName = "id")
        private User createdBy;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="updated_by",referencedColumnName = "id")
        private User updatedBy;
    }
