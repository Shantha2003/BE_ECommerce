package com.example.java.controller;

import com.example.java.model.OrderItem;
import com.example.java.repository.OrderItemRepository;
import com.example.java.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orderItem")
public class OrderItemController {
@Autowired
    private  OrderItemService orderItemService;

    @GetMapping("")
    public List<OrderItem> getAll() {
        return orderItemService.getAll();
    }

    @PostMapping("/createOrderItem")
    public OrderItem create(@RequestBody OrderItem item) {
        return orderItemService.create(item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        orderItemService.delete(id);
    }
}
