package com.example.OrderManagementSystem.Order.Management.System.repository;

import com.example.OrderManagementSystem.Order.Management.System.model.Order;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public class OrderRepository {

    private  Map<String,Order> orderstore=new ConcurrentHashMap<String, Order>();

    public void save(Order order){
        orderstore.put(order.getOrder_id(),order);
    }

    public Map<String, Order> findAll(){
        return orderstore;
    }
    public Order findById(String id){
        return orderstore.get(id);
    }



}
