package com.example.OrderManagementSystem.Order.Management.System.service;

import com.example.OrderManagementSystem.Order.Management.System.exception.OrderNotFoundException;
import com.example.OrderManagementSystem.Order.Management.System.logging.FileLogger;
import com.example.OrderManagementSystem.Order.Management.System.model.Order;
import com.example.OrderManagementSystem.Order.Management.System.model.OrderStatus;
import com.example.OrderManagementSystem.Order.Management.System.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private FileLogger fileLogger;

    private ExecutorService executorService= Executors.newFixedThreadPool(5);

    public Order createorder(Order order){
        repository.save(order);
        fileLogger.log("Created order : "+ order.getOrder_id());
        executorService.submit(()->processOrder(order));
        return order;
    }

    public void processOrder(Order order){

        try{
            order.setOrder_status(OrderStatus.PROCESSING);
            fileLogger.log("Processing Order : "+order.getOrder_id());
            Thread.sleep(2000);
            order.setOrder_status(OrderStatus.COMPLETED);
            fileLogger.log("Completed Order: "+order.getOrder_id());
        }
        catch(Exception e){
            order.setOrder_status(OrderStatus.FAILED);
            fileLogger.log("Failed Order : "+order.getOrder_id());
        }
    }

    public Map<String, Order> getAllOrder(){
        return repository.findAll();
    }

    public Order getOrderById(String id){

        Order order=repository.findById(id);
        if(order==null){
            throw new OrderNotFoundException("Order not found "+id);
        }
        return order;
    }

}
