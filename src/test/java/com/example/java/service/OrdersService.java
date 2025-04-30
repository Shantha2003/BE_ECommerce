package com.example.java.service;

import com.example.java.model.Orders;
import com.example.java.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;


    public List<Orders> getAll() {
        return ordersRepository.findAll();
    }

    public ResponseEntity<Orders> getById(Long id) {
        return ordersRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    public Orders create(Orders order) {
        return ordersRepository.save(order);
    }


    public void delete(Long id) {
        ordersRepository.deleteById(id);
    }
}
