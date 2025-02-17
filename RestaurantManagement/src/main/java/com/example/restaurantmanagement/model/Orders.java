package com.example.restaurantmanagement.model;

import com.example.restaurantmanagement.model.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity(name = "orders")
@Data
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name="table_id", nullable = false)
    private Long tableId;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable = false)
    private Customer customerId;

    @Column(name="order_date", nullable = false)
    @CreationTimestamp
    private Date orderDate;

    @Column(name = "status", nullable = false)
    private OrderStatus status = OrderStatus.PENDING;

    @Column(name = "total_amount", nullable = false)
    private double totalAmount;

}
