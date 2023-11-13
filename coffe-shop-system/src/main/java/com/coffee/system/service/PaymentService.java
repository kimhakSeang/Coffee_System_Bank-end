package com.coffee.system.service;

import com.coffee.system.model.Payment;

public interface PaymentService {

    Payment getPaymentById(int id);
    
    Payment insertPayment(Payment payment);
    
    Payment updatePayment(Payment payment);
    
    String deletePayment(int id);
}
