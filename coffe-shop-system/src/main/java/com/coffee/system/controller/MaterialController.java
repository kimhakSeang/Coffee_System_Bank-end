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

import com.coffee.system.model.dto.MaterialDto;
import com.coffee.system.model.entity.Material;
import com.coffee.system.service.MaterialService;


@RestController
@RequestMapping("/material")
public class MaterialController {
	@Autowired
	private MaterialService MaterialService;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Material> getMaterialById(@PathVariable int id){
		return ResponseEntity.ok(MaterialService.getMaterialById(id));
	}
	
	@GetMapping("/get/list")
	public ResponseEntity<List<Material>> getMaterialById(){
		return ResponseEntity.ok(MaterialService.getMaterialList());
	}
	
	@PostMapping("/add")
	public ResponseEntity<Material> insertMaterial(@RequestBody MaterialDto MaterialDto){
		return ResponseEntity.ok(MaterialService.insertMaterial(MaterialDto));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Material> updateMaterial(@PathVariable int id,  @RequestBody MaterialDto MaterialDto){
		return ResponseEntity.ok(MaterialService.updateMaterial(id, MaterialDto));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteMaterial(@PathVariable int id){
		return ResponseEntity.ok(MaterialService.deleteMaterial(id));
	}
}
