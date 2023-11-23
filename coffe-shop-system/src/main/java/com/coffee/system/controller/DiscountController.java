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

import com.coffee.system.model.dto.DiscountDto;
import com.coffee.system.model.entity.Discount;
import com.coffee.system.service.DiscountService;

@RestController
@RequestMapping("/discount")
public class DiscountController {
	@Autowired
	private DiscountService discountService;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Discount> getDiscountById(@PathVariable int id){
		return ResponseEntity.ok(discountService.getDiscountById(id));
	}
	
	@GetMapping("/get/list")
	public ResponseEntity<List<Discount>> getDiscountById(){
		return ResponseEntity.ok(discountService.getDiscountList());
	}
	
	@PostMapping("/add")
	public ResponseEntity<Discount> insertDiscount(@RequestBody DiscountDto discountDto){
		return ResponseEntity.ok(discountService.insertDiscount(discountDto));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Discount> updateDiscount(@PathVariable int id,  @RequestBody DiscountDto discountDto){
		return ResponseEntity.ok(discountService.updateDiscount(id, discountDto));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteDiscount(@PathVariable int id){
		return ResponseEntity.ok(discountService.deleteDiscount(id));
	}
}
