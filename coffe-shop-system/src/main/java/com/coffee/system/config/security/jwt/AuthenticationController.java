package com.coffee.system.config.security.jwt;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.system.config.security.dto.UserLoginDto;
import com.coffee.system.config.security.model.RequestLogin;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    private JwtService jwtService= new JwtService();

    @PostMapping("/custom-login-endpoint")
    public ResponseEntity<?> authenticateUser(@RequestBody UserLoginDto userLoginDto) {

        // Perform authentication (validate user credentials)
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userLoginDto.getEmail(), userLoginDto.getPassword())
        );

        // Generate JWT token
        String token = jwtService.generateToken(authentication);

        // Return the JWT token in the response
        Map<String, String> jwtAuthenticationResponse = new HashMap<>();
        jwtAuthenticationResponse.put("access_token", token);
        jwtAuthenticationResponse.put("refresh_token", token);
        jwtAuthenticationResponse.put("permission", authentication.getAuthorities().toString());
        jwtAuthenticationResponse.put("user", authentication.getName());
        return ResponseEntity.ok(jwtAuthenticationResponse);
    }
}