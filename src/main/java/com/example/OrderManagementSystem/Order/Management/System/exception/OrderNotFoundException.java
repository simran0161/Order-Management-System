package com.example.OrderManagementSystem.Order.Management.System.exception;

public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(String message){
        super(message);
    }
}
