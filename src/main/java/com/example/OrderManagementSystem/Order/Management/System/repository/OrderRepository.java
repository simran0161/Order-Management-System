package com.example.OrderManagementSystem.Order.Management.System.repository;

import com.example.OrderManagementSystem.Order.Management.System.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public interface OrderRepository  extends JpaRepository<Order,String> {



}
