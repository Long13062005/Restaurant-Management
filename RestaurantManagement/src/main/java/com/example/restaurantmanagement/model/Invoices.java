package com.example.restaurantmanagement.model;

import com.example.restaurantmanagement.model.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity(name = "invoices")
@Data
@NoArgsConstructor
public class Invoices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Orders order;

    @Column(name="total_amount", nullable = false)
    private double totalAmount;

    @Column(name="payment_method", nullable = false)
    private PaymentMethod paymentMethod;

    @Column(name="payment_date", nullable = false)
    @CreationTimestamp
    private Date paymentDate;
}
