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

import com.coffee.system.model.dto.MenuDto;
import com.coffee.system.model.system.Menu;
import com.coffee.system.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {
	@Autowired
	private MenuService MenuService;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Menu> getMenuById(@PathVariable int id){
		return ResponseEntity.ok(MenuService.getMenuById(id));
	}
	
	@GetMapping("/get/list")
	public ResponseEntity<List<Menu>> getMenuById(){
		return ResponseEntity.ok(MenuService.getMenuList());
	}
	
	@PostMapping("/add")
	public ResponseEntity<Menu> insertMenu(@RequestBody MenuDto menuDto){
		return ResponseEntity.ok(MenuService.insertMenu(menuDto));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Menu> updateMenu(@PathVariable int id,  @RequestBody MenuDto menuDto){
		return ResponseEntity.ok(MenuService.updateMenu(id, menuDto));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteMenu(@PathVariable int id){
		return ResponseEntity.ok(MenuService.deleteMenu(id));
	}
}
