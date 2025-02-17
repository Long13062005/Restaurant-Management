package com.example.restaurantmanagement.service;

import com.example.restaurantmanagement.model.Orders;

import java.util.List;

public interface IOrdersService {
    Orders createOrder(int tableId, List<Integer> dishIds);
    void updateOrderStatus(int orderId, String status);
    boolean cancelOrder(int orderId);
}
