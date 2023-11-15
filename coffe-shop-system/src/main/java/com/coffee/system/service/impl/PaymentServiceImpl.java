package com.coffee.system.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.system.exception.RuntimeExceptionImpl;
import com.coffee.system.mapper.PaymentMapper;
import com.coffee.system.model.Payment;
import com.coffee.system.model.dto.PaymentDto;
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
	public List<Payment> getPaymentList() {
		return paymentRepository.findAll();
	}

	@Override
	public Payment insertPayment(PaymentDto paymentDto) {
		Payment payment = PaymentMapper.INSTANCE.toPayment(paymentDto);
		paymentRepository.save(payment);
		return payment;
	}

	@Override
	public Payment updatePayment(int id, PaymentDto paymentDto) {
		getPaymentById(id);
		Payment payment = PaymentMapper.INSTANCE.toPayment(paymentDto);
		payment.setId(id);
		return paymentRepository.save(payment);
	}
	@Override
	public String deletePayment(int id) {
		getPaymentById(id);
		paymentRepository.deleteById(id);
		return "Delete Success.";
	}
}
