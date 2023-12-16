package com.coffee.system.config.security.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coffee.system.config.security.service.TokenService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/email")
@RequiredArgsConstructor
public class TokenController {
	private final TokenService emailService;
	
	@GetMapping("/confirm")
	public String confirmEmail(@RequestParam(value = "token") String token ){
		emailService.confirm(token);
		return "confirmed_form.html";
	}

}
