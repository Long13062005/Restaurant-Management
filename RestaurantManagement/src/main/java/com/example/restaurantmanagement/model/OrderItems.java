package com.example.restaurantmanagement.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "order_items")
@Data
@NoArgsConstructor
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Orders order;

    @ManyToOne
    @JoinColumn(name="menu_id")
    private Menu menu;

    @Column(name="quantity", nullable = false)
    private int quantity;

    @Column(name="price", nullable = false)
    private double price;
}
