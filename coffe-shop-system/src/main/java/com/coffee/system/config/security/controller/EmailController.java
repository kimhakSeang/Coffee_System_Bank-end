package com.coffee.system.config.security.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.system.config.security.service.EmailService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {
	private final EmailService emailService;
	
	@GetMapping("/confirm")
	public ResponseEntity<?> confirmEmail(@RequestParam(value = "token") String token ){
		emailService.confirm(token);
		return ResponseEntity.ok("Confirmed");
	}

}
