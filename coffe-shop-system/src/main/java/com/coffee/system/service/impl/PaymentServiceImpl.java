package com.coffee.system.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.system.exception.RuntimeExceptionImpl;
import com.coffee.system.model.Payment;
import com.coffee.system.repository.PaymentRepository;
import com.coffee.system.service.PaymentService;
import com.coffee.system.util.ErrorUtil;
@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
    private PaymentRepository paymentRepository;
    
	@Override
	public Payment getPaymentById(int id){
		Optional<Payment> payment= paymentRepository.findById(id);
		if(payment.isEmpty()) {
			throw new RuntimeExceptionImpl(ErrorUtil.NOT_FOUND,"Payment's id("+id+") not found!");
		}
		return payment.get();
	}

	@Override
	public Payment insertPayment(Payment payment) {
		return paymentRepository.save(payment);
	}

	@Override
	public Payment updatePayment(Payment payment) {
		getPaymentById(payment.getId());
		return paymentRepository.save(payment);
	}

	@Override
	public String deletePayment(int id) {
		getPaymentById(id);
		paymentRepository.deleteById(id);
		return "Delete Success.";
	}
}
