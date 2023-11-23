package com.coffee.system.config.security.controller;


import java.util.Date;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coffee.system.config.security.dto.EmailTokenDto;
import com.coffee.system.config.security.dto.UserLoginDto;
import com.coffee.system.config.security.model.EmailToken;
import com.coffee.system.config.security.model.UserRequestLogin;
import com.coffee.system.config.security.service.EmailService;
import com.coffee.system.config.security.service.UserLoginService;
import com.coffee.system.mapper.UserMapper;
import com.coffee.system.model.dto.UserDto;
import com.coffee.system.service.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user_login")
@RequiredArgsConstructor
public class UserRequestLoginController {
	private final UserLoginService userLoginService;
	private final UserService userService;
	private final EmailService emailService;
	
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
			try {
				
				// CHECK Email and TELL 
				Optional<EmailToken> checkEmail = emailService.getAll()
						   		.stream()
						   		.filter(u->u.getUserLogin().getEmail().equals(userLoginDto.getEmail()))
						   		.findFirst();
				
				if(checkEmail.isPresent()) {
				    throw new RuntimeException("Email is ready exist!");
				}
				
				
				// Register User Login
				UserRequestLogin userRequestLogin = userLoginService.register(userLoginDto);
				UserDto userDto = UserMapper.INSTANCE.toUserDto(userRequestLogin.getUser());
				
				
				
				// Register User
				userService.insertUser(userDto);
				
				// Email Sender
				String token = emailService.signUp(new EmailTokenDto("", false, userRequestLogin.getId(),null, null,null));
				EmailToken getEmailToken = emailService.findEmailByToken(token);
				emailService.sender(getEmailToken, userLoginDto.getUsername());
				
				return ResponseEntity.ok("Register success!");
				
			}catch(Exception ex) {
				throw ex;
			}
		
		
	}
}
