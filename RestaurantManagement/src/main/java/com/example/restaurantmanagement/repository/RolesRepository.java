package com.example.restaurantmanagement.repository;

import com.example.restaurantmanagement.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
    Roles findByName(String name);
}
