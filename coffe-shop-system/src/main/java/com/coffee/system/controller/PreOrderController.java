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

import com.coffee.system.model.dto.PreOrderDto;
import com.coffee.system.model.system.PreOrder;
import com.coffee.system.service.PreOrderService;

@RestController
@RequestMapping("/pre-order")
public class PreOrderController {
	@Autowired
	private PreOrderService preOrderService;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<PreOrder> getPreOrderById(@PathVariable int id){
		return ResponseEntity.ok(preOrderService.getPreOrderById(id));
	}
	
	@GetMapping("/get/list")
	public ResponseEntity<List<PreOrder>> getPreOrderById(){
		return ResponseEntity.ok(preOrderService.getPreOrderList());
	}
	
	@PostMapping("/add")
	public ResponseEntity<PreOrder> insertPreOrder(@RequestBody PreOrderDto preOrderDto){
		return ResponseEntity.ok(preOrderService.insertPreOrder(preOrderDto));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<PreOrder> updatePreOrder(@PathVariable int id,  @RequestBody PreOrderDto preOrderDto){
		return ResponseEntity.ok(preOrderService.updatePreOrder(id, preOrderDto));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePreOrder(@PathVariable int id){
		return ResponseEntity.ok(preOrderService.deletePreOrder(id));
	}
}
