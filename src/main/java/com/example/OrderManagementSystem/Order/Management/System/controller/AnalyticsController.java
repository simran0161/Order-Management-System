package com.example.OrderManagementSystem.Order.Management.System.controller;

import com.example.OrderManagementSystem.Order.Management.System.model.Order;
import com.example.OrderManagementSystem.Order.Management.System.model.OrderStatus;
import com.example.OrderManagementSystem.Order.Management.System.model.OrderType;
import com.example.OrderManagementSystem.Order.Management.System.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    @Autowired
    private AnalyticsService service;

    @GetMapping("/total")
    public double total(){
        return service.totalOrderAmount();
    }

    @GetMapping("/buy-sell")
    public Map<OrderType,Long> count(){
        return service.countBuySell();
    }

    @GetMapping("/group-status")
    public Map<OrderStatus, List<Order>> group(){
        return service.groupBystatus();
    }

    @GetMapping("/top-customer")
    public Optional<String> topCustomer(){
        return service.topCustomerByVolume();
    }

}
