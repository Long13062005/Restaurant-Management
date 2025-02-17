package com.example.restaurantmanagement.service.impl;

import com.example.restaurantmanagement.model.Orders;
import com.example.restaurantmanagement.repository.OrdersRepository;
import com.example.restaurantmanagement.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdersService implements IOrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public Orders createOrder(int tableId, List<Integer> dishIds) {
        return null;
    }

    @Override
    public void updateOrderStatus(int orderId, String status) {

    }

    @Override
    public boolean cancelOrder(int orderId) {
        return false;
    }
}
