package com.example.restaurantmanagement.service;

import com.example.restaurantmanagement.model.Roles;

public interface IRolesService {
    Roles findByName(String name);
}
