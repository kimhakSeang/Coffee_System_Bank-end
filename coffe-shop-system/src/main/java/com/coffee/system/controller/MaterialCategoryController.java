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

import com.coffee.system.model.dto.MaterialCategoryDto;
import com.coffee.system.model.entity.MaterialCategory;
import com.coffee.system.service.MaterialCategoryService;


@RestController
@RequestMapping("/material-category")
public class MaterialCategoryController {
	@Autowired
	private MaterialCategoryService MaterialCategoryService;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<MaterialCategory> getMaterialCategoryById(@PathVariable int id){
		return ResponseEntity.ok(MaterialCategoryService.getMaterialCategoryById(id));
	}
	
	@GetMapping("/get/list")
	public ResponseEntity<List<MaterialCategory>> getMaterialCategoryById(){
		return ResponseEntity.ok(MaterialCategoryService.getMaterialCategoryList());
	}
	
	@PostMapping("/add")
	public ResponseEntity<MaterialCategory> insertMaterialCategory(@RequestBody MaterialCategoryDto MaterialCategoryDto){
		return ResponseEntity.ok(MaterialCategoryService.insertMaterialCategory(MaterialCategoryDto));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<MaterialCategory> updateMaterialCategory(@PathVariable int id,  @RequestBody MaterialCategoryDto MaterialCategoryDto){
		return ResponseEntity.ok(MaterialCategoryService.updateMaterialCategory(id, MaterialCategoryDto));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteMaterialCategory(@PathVariable int id){
		return ResponseEntity.ok(MaterialCategoryService.deleteMaterialCategory(id));
	}
}
