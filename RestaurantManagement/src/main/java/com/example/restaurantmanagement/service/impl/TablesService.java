package com.example.restaurantmanagement.service.impl;

import com.example.restaurantmanagement.model.Tables;
import com.example.restaurantmanagement.service.ITablesService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TablesService implements ITablesService {
    @Override
    public List<Tables> viewTables(String status) {
        return null;
    }

    @Override
    public void updateTableStatus(int tableId, String status) {

    }

    @Override
    public boolean reserveTable(int tableId, String customerName, String reservationTime) {
        return false;
    }
}
