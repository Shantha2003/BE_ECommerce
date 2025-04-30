package com.example.java.controller;

import com.example.java.model.Order;
import com.example.java.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
        @Autowired
        private OrderService ordersService;
    @GetMapping("")
    public List<Order> getAllOrders() {
        return ordersService.getAll();
    }

    @PostMapping("/createOrder")
    public Order createOrder(@RequestBody Order order) {
        return ordersService.create(order);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        return ordersService.getById(id);

    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        ordersService.delete(id);
    }
}