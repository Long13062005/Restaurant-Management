package com.example.restaurantmanagement.service.impl;

import com.example.restaurantmanagement.model.Menu;
import com.example.restaurantmanagement.service.IMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService implements IMenuService {
    @Override
    public void addDish(String dishName, String category, double price, boolean available) {

    }

    @Override
    public void updateDish(int dishId, String dishName, String category, double price, boolean available) {

    }

    @Override
    public void deleteDish(int dishId) {

    }

    @Override
    public void updateDishStatus(int dishId, boolean available) {

    }

    @Override
    public List<Menu> viewMenu(String category, double minPrice, double maxPrice, Boolean available) {
        return null;
    }
}
