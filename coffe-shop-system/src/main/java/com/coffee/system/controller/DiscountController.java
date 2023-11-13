package com.coffee.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coffee.system.model.Discount;
import com.coffee.system.model.dto.DiscountDto;
import com.coffee.system.service.DiscountService;

@Controller
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
	
	@RequestMapping("/add")
	public ResponseEntity<Discount> insertDiscount(@RequestBody DiscountDto DiscountDto){
		return ResponseEntity.ok(discountService.insertDiscount(DiscountDto));
	}
	
	@RequestMapping("/update/{id}")
	public ResponseEntity<Discount> updateDiscount(@PathVariable int id,  @RequestBody DiscountDto DiscountDto){
		return ResponseEntity.ok(discountService.updateDiscount(id, DiscountDto));
	}
	
	@RequestMapping("/delete/{id}")
	public ResponseEntity<String> deleteDiscount(@PathVariable int id){
		return ResponseEntity.ok(discountService.deleteDiscount(id));
	}
}
