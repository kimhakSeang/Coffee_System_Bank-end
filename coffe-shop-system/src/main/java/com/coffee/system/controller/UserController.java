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

import com.coffee.system.model.dto.UserDto;
import com.coffee.system.model.user.User;
import com.coffee.system.service.UserService;


@RestController
@RequestMapping("/User")
public class UserController {
	@Autowired
	private UserService UserService;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id){
		return ResponseEntity.ok(UserService.getUserById(id));
	}
	
	@GetMapping("/get/list")
	public ResponseEntity<List<User>> getUserById(){
		return ResponseEntity.ok(UserService.getUserList());
	}
	
	@PostMapping("/add")
	public ResponseEntity<User> insertUser(@RequestBody UserDto UserDto){
		return ResponseEntity.ok(UserService.insertUser(UserDto));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id,  @RequestBody UserDto UserDto){
		return ResponseEntity.ok(UserService.updateUser(id, UserDto));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id){
		return ResponseEntity.ok(UserService.deleteUser(id));
	}
}
