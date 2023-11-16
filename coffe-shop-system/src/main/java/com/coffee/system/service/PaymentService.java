package com.coffee.system.service;

import java.util.List;

import com.coffee.system.model.dto.PaymentDto;
import com.coffee.system.model.system.Payment;

public interface PaymentService {

    Payment getPaymentById(int id);
    
    List<Payment> getPaymentList();
    
    Payment insertPayment(PaymentDto paymentDto);
    
    Payment updatePayment(int id, PaymentDto paymentDto);
    
    String deletePayment(int id);
}
