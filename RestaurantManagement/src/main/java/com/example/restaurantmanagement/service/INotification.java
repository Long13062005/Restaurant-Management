package com.example.restaurantmanagement.service;

public interface INotification {
    void sendOrderStatusNotification(int orderId, String status);
    void sendEmail(String to, String subject, String content);
}
