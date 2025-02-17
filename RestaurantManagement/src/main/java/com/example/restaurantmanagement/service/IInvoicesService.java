package com.example.restaurantmanagement.service;

import com.example.restaurantmanagement.model.Invoices;

public interface IInvoicesService {
    Invoices createInvoice(int orderId, String paymentMethod);
    void storePaymentInfo(int invoiceId, String paymentMethod, double amount);
    byte[] exportInvoiceAsPDF(int invoiceId);
}
