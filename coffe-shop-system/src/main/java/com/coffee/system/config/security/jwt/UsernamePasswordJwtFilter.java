package com.coffee.system.config.security.jwt;


import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.coffee.system.config.security.model.UserLogin;
import com.coffee.system.config.security.service.TokenService;
import com.coffee.system.config.security.service.UserService;
import com.coffee.system.exception.RuntimeExceptionImpl;
import com.coffee.system.util.ErrorUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UsernamePasswordJwtFilter  extends UsernamePasswordAuthenticationFilter {
	private final AuthenticationManager authenticationManager ;
	private JwtService jwtService= new JwtService();
    private final TokenService emailService;
    private UserLogin requestLogin = new UserLogin();
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
		try {
		    requestLogin = new ObjectMapper().readValue(request.getInputStream(), UserLogin.class);
		    
		    Authentication authenticationToken = new UsernamePasswordAuthenticationToken(requestLogin.getEmail(), requestLogin.getPassword());
			
		    // Validate Email Verify
		    if(!emailService.isVerify(requestLogin.getEmail())) {
		    	throw new RuntimeExceptionImpl(ErrorUtil.ERROR_TOKEN, "Your email not yet verify!");
		    }; 
		    
			Authentication authentication = authenticationManager.authenticate(authenticationToken);
			
			return authentication;
//		} catch (AuthenticationException  e) {
//			throw new RuntimeExceptionImpl(ErrorUtil.WRONG_CREDENTAIL, "Wrong Password!");
//		}catch(RuntimeException e) {
//			throw e;
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeExceptionImpl(ErrorUtil.BAD_REQUEST, "Error while login!");
		}
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
		String token = jwtService.generateToken(authResult);
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("{\"token\": \"" + token + "\""
        							+ ", user\": \"" + requestLogin.getEmail()+"\""
        							+ ", user\": \"" + "ADMIN" +"\""
        							+ "}");
	}
	
	
}
