package com.example.restaurantmanagement.model;


import com.example.restaurantmanagement.model.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "tables")
@Data
@NoArgsConstructor
public class Tables {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name="table_number", nullable = false,unique = true)
    private int tableNumber;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Column(name = "status", nullable = false)
    private Status status = Status.AVAILABLE;

}
