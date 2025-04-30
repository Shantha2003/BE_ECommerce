package com.example.java.service;

import com.example.java.model.Order;
import com.example.java.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository ordersRepository;
    public List<Order> getAll() {
        return ordersRepository.findAll();
    }

    public ResponseEntity<Order> getById(Long id) {
        return ordersRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    public Order create(Order order) {
        return ordersRepository.save(order);
    }


    public void delete(Long id) {
        ordersRepository.deleteById(id);
    }
}
