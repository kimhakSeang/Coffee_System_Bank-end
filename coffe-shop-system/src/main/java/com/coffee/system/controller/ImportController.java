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

import com.coffee.system.model.dto.ImportDto;
import com.coffee.system.model.system.Import;
import com.coffee.system.service.ImportService;

@RestController
@RequestMapping("/import")
public class ImportController {
	@Autowired
	private ImportService ImportService;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Import> getImportById(@PathVariable int id){
		return ResponseEntity.ok(ImportService.getImportById(id));
	}
	
	@GetMapping("/get/list")
	public ResponseEntity<List<Import>> getImportById(){
		return ResponseEntity.ok(ImportService.getImportList());
	}
	
	@PostMapping("/add")
	public ResponseEntity<Import> insertImport(@RequestBody ImportDto ImportDto){
		return ResponseEntity.ok(ImportService.insertImport(ImportDto));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Import> updateImport(@PathVariable int id,  @RequestBody ImportDto ImportDto){
		return ResponseEntity.ok(ImportService.updateImport(id, ImportDto));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteImport(@PathVariable int id){
		return ResponseEntity.ok(ImportService.deleteImport(id));
	}
}
