package com.example.restaurantmanagement.model;

import com.example.restaurantmanagement.model.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity(name = "menu")
@Data
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name="category", nullable = false, length = 100)
    private String category;

    @Column(name="price", nullable = false,length = 10)
    private double price;

    @Column(name="status", nullable = false)
    private Status status = Status.AVAILABLE;

    @Column(name="created_at", nullable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column(name="updated_at", nullable = false)
    @CreationTimestamp
    private Date updatedAt;
}
