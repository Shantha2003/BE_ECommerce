package com.example.java.controller;

import com.example.java.model.Orders;
import com.example.java.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrdersController {
        @Autowired
        private OrdersService ordersService;
    @GetMapping("")
    public List<Orders> getAllOrders() {
        return ordersService.getAll();
    }

    @PostMapping("/createOrder")
    public Orders createOrder(@RequestBody Orders order) {
        return ordersService.create(order);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrder(@PathVariable Long id) {
        return ordersService.getById(id);

    }
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        ordersService.delete(id);
    }
}