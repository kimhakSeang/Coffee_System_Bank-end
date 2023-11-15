package com.coffee.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.system.model.Payment;
import com.coffee.system.model.dto.PaymentDto;
import com.coffee.system.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	private PaymentService PaymentService;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable int id){
		return ResponseEntity.ok(PaymentService.getPaymentById(id));
	}
	
	@GetMapping("/get/list")
	public ResponseEntity<List<Payment>> getPaymentById(){
		return ResponseEntity.ok(PaymentService.getPaymentList());
	}
	
	@PostMapping("/add")
	public ResponseEntity<Payment> insertPayment(@RequestBody PaymentDto paymentDto){
		return ResponseEntity.ok(PaymentService.insertPayment(paymentDto));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Payment> updatePayment(@PathVariable int id,  @RequestBody PaymentDto paymentDto){
		return ResponseEntity.ok(PaymentService.updatePayment(id, paymentDto));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePayment(@PathVariable int id){
		return ResponseEntity.ok(PaymentService.deletePayment(id));
	}
}
