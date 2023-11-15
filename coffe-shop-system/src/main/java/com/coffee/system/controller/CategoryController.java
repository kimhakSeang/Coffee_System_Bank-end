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

import com.coffee.system.model.Category;
import com.coffee.system.model.dto.CategoryDto;
import com.coffee.system.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable int id){
		return ResponseEntity.ok(categoryService.getCategoryById(id));
	}
	
	@GetMapping("/get/list")
	public ResponseEntity<List<Category>> getCategoryById(){
		return ResponseEntity.ok(categoryService.getCategoryList());
	}
	
	@PostMapping("/add")
	public ResponseEntity<Category> insertCategory(@RequestBody CategoryDto categoryDto){
		return ResponseEntity.ok(categoryService.insertCategory(categoryDto));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable int id,  @RequestBody CategoryDto categoryDto){
		return ResponseEntity.ok(categoryService.updateCategory(id, categoryDto));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable int id){
		return ResponseEntity.ok(categoryService.deleteCategory(id));
	}
}