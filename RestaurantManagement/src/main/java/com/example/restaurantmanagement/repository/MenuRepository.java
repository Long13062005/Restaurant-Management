package com.example.restaurantmanagement.repository;

import com.example.restaurantmanagement.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    Menu findByName(String name);
}
