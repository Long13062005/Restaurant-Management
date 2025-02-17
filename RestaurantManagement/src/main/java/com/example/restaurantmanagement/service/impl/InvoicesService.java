package com.example.restaurantmanagement.service.impl;

import com.example.restaurantmanagement.model.Invoices;
import com.example.restaurantmanagement.repository.InvoicesRepository;
import com.example.restaurantmanagement.service.IInvoicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoicesService implements IInvoicesService {
    @Autowired
    private InvoicesRepository invoicesRepository;
    @Override
    public Invoices createInvoice(int orderId, String paymentMethod) {
        return null;
    }

    @Override
    public void storePaymentInfo(int invoiceId, String paymentMethod, double amount) {

    }

    @Override
    public byte[] exportInvoiceAsPDF(int invoiceId) {
        return new byte[0];
    }
}
