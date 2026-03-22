package com.example.OrderManagementSystem.Order.Management.System.controller;

import com.example.OrderManagementSystem.Order.Management.System.model.Order;
import com.example.OrderManagementSystem.Order.Management.System.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public Order createOrder(@RequestBody Order order){
        return orderService.createorder(order);
    }

    @GetMapping("/all")
    public List<Order> getAllOrders(){
        return orderService.getAllOrder();
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable String id){
        return orderService.getOrderById(id);
    }
}
