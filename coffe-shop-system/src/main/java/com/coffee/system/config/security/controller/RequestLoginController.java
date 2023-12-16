package com.coffee.system.config.security.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.system.config.security.dto.UserLoginDto;
import com.coffee.system.config.security.service.UserLoginService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user_login")
@RequiredArgsConstructor
public class RequestLoginController {
	private final UserLoginService userLoginService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Integer id){
		return ResponseEntity.ok(userLoginService.getUserRequestLogin(id));
	}
	
	@GetMapping
	public ResponseEntity<?> getListUser(){
		return ResponseEntity.ok(userLoginService.getListUserLogin());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody UserLoginDto userLoginDto){
		userLoginService.update(id, userLoginDto);
		return ResponseEntity.ok("Update Sucess!");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUserLogin(@PathVariable Integer id){
		userLoginService.delete(id);
		return ResponseEntity.ok("Delete success!");
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> registerUserLogin(@RequestBody UserLoginDto userLoginDto){
		return ResponseEntity.ok(userLoginService.register(userLoginDto));
	}
	@GetMapping("/user/{id}")
	public ResponseEntity<?> registerUserLogin(@PathVariable int id){
		return ResponseEntity.ok(userLoginService.getUserRequestLoginByUserId(id));
	}
}

