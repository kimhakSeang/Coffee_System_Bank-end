package com.coffee.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coffee.system.model.Customer;
import com.coffee.system.model.dto.CustomerDto;
import com.coffee.system.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int id){
		return ResponseEntity.ok(customerService.getCustomerById(id));
	}
	
	@GetMapping("/get/list")
	public ResponseEntity<List<Customer>> getCustomerById(){
		return ResponseEntity.ok(customerService.getCustomerList());
	}
	
	@RequestMapping("/add")
	public ResponseEntity<Customer> insertCustomer(@RequestBody CustomerDto CustomerDto){
		return ResponseEntity.ok(customerService.insertCustomer(CustomerDto));
	}
	
	@RequestMapping("/update/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable int id,  @RequestBody CustomerDto CustomerDto){
		return ResponseEntity.ok(customerService.updateCustomer(id, CustomerDto));
	}
	
	@RequestMapping("/delete/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int id){
		return ResponseEntity.ok(customerService.deleteCustomer(id));
	}
}
