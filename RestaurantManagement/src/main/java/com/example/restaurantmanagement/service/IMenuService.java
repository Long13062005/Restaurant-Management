package com.example.restaurantmanagement.service;

import com.example.restaurantmanagement.model.Menu;

import java.util.List;

public interface IMenuService {
    void addDish(String dishName, String category, double price, boolean available);
    void updateDish(int dishId, String dishName, String category, double price, boolean available);
    void deleteDish(int dishId);
    void updateDishStatus(int dishId, boolean available);
    List<Menu> viewMenu(String category, double minPrice, double maxPrice, Boolean available);
}
