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

import com.coffee.system.model.Item;
import com.coffee.system.model.dto.ItemDto;
import com.coffee.system.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemService ItemService;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable int id){
		return ResponseEntity.ok(ItemService.getItemById(id));
	}
	
	@GetMapping("/get/list")
	public ResponseEntity<List<Item>> getItemById(){
		return ResponseEntity.ok(ItemService.getItemList());
	}
	
	@PostMapping("/add")
	public ResponseEntity<Item> insertItem(@RequestBody ItemDto itemDto){
		return ResponseEntity.ok(ItemService.insertItem(itemDto));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Item> updateItem(@PathVariable int id,  @RequestBody ItemDto itemDto){
		return ResponseEntity.ok(ItemService.updateItem(id, itemDto));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteItem(@PathVariable int id){
		return ResponseEntity.ok(ItemService.deleteItem(id));
	}
}
