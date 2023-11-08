package com.coffee.system.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@RequestMapping("/get/{id}")
	public ResponseEntity<Integer> getCategoryById(@PathVariable int id){
		return ResponseEntity.ok(id);
	}

}