package com.example.restaurantmanagement.service;

import com.example.restaurantmanagement.model.Tables;

import java.util.List;

public interface ITablesService {
    List<Tables> viewTables(String status);
    void updateTableStatus(int tableId, String status);
    boolean reserveTable(int tableId, String customerName, String reservationTime);
}