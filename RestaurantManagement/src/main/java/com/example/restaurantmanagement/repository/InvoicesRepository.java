package com.example.restaurantmanagement.repository;

import com.example.restaurantmanagement.model.Invoices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoicesRepository extends JpaRepository<Invoices, Long> {
}
