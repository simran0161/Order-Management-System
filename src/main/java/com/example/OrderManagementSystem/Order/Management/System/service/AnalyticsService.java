package com.example.OrderManagementSystem.Order.Management.System.service;

import com.example.OrderManagementSystem.Order.Management.System.model.Order;
import com.example.OrderManagementSystem.Order.Management.System.model.OrderStatus;
import com.example.OrderManagementSystem.Order.Management.System.model.OrderType;
import com.example.OrderManagementSystem.Order.Management.System.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnalyticsService {

    @Autowired
    private OrderRepository repository;

    public double totalOrderAmount(){
        return repository.findAll().values().stream().mapToDouble(Order::getAmount).sum();
    }

    public Map<OrderType, Long> countBuySell(){
        return repository.findAll().values().stream().collect(Collectors.groupingBy(Order::getOrder_type,Collectors.counting()));
    }

    public Map<OrderStatus, List<Order>> groupBystatus(){
        return repository.findAll().values().stream().collect(Collectors.groupingBy(Order::getOrder_status));
    }

    public Optional<String> topCustomerByVolume(){
        return repository.findAll().values().stream().collect(Collectors.groupingBy(Order::getCustomer_id,Collectors.summingDouble(Order::getAmount)))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
    }

}
