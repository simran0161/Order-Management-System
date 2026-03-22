package com.example.OrderManagementSystem.Order.Management.System.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private String order_id;

    private String customer_id;

    @Enumerated(EnumType.STRING)
    private OrderType order_type;

    @Enumerated(EnumType.STRING)
    private OrderStatus order_status;

    private double amount;
    private int quantity;


    public Order() {
    }

    public Order(String order_id, String customer_id, OrderType order_type, OrderStatus order_status, int quantity, double amount) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.order_type = order_type;
        this.order_status = order_status;
        this.quantity = quantity;
        this.amount = amount;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public OrderType getOrder_type() {
        return order_type;
    }

    public void setOrder_type(OrderType order_type) {
        this.order_type = order_type;
    }

    public OrderStatus getOrder_status() {
        return order_status;
    }

    public void setOrder_status(OrderStatus order_status) {
        this.order_status = order_status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
