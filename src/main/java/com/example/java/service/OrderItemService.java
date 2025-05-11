package com.example.java.service;

import com.example.java.model.OrderItem;
import com.example.java.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository repository;

    public List<OrderItem> getAll() {
        return repository.findAll();
    }

    public OrderItem getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public OrderItem create(OrderItem item) {
        return repository.save(item);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    }

