package com.example.restaurantmanagement.repository;

import com.example.restaurantmanagement.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {
    Optional<Users> findByUsername(String username);

    @Modifying
    @Transactional
    @Query("UPDATE users u SET u.deleted = true WHERE u.id = ?1")
    void softDeleteById(Integer userId);
}
