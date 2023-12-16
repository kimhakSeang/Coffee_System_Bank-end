package com.coffee.system.config.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.system.config.security.dto.TokenDto;
import com.coffee.system.config.security.model.Token;
import com.coffee.system.config.security.model.User;
import com.coffee.system.config.security.service.TokenService;
import com.coffee.system.config.security.service.UserService;
import com.coffee.system.model.dto.UserDto;


@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private TokenService emailService;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id){
		return ResponseEntity.ok(userService.getUserById(id));
	}
	
	@GetMapping("/get/list")
	public ResponseEntity<List<User>> getUserById(){
		return ResponseEntity.ok(userService.getUserList());
	}
	
	@PostMapping("/add")
	public ResponseEntity<User> insertUser(@RequestBody UserDto userDto){
		User user = userService.insertUser(userDto);
		
		//Email Sender
		String emailVerifyToken = emailService.signUp(new TokenDto("",  false, user.getId(), null, null,null));
		Token getEmailToken = emailService.findEmailByToken(emailVerifyToken);
		emailService.sender(getEmailToken, user.getEmail());
		
		return ResponseEntity.ok(user);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id,  @RequestBody UserDto UserDto){
		return ResponseEntity.ok(userService.updateUser(id, UserDto));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id){
		return ResponseEntity.ok(userService.deleteUser(id));
	}
}
