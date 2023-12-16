package com.coffee.system.config.security.jwt;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.coffee.system.config.security.exception.CustomAccessDeniedHandler;
import com.coffee.system.config.security.exception.CustomAuthenticationFailureHandler;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class JwtAuthTokenVerify extends OncePerRequestFilter {

	private final UserDetailsService userDetailsService;
	private JwtService jwtService= new JwtService();
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)throws ServletException, IOException {
		
		final String authHeader = request.getHeader("Authorization");
		
		if(authHeader == null || !authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
//			throw new RuntimeExceptionImpl(ErrorUtil.BAD_REQUEST,"Token Invalid!");
			return;
		}
		String token = authHeader.replace("Bearer ", "");
		
        try {
        	Claims body = jwtService.extractAllCliams(token);
			String email = body.getSubject();
			
			if(email != null && SecurityContextHolder.getContext().getAuthentication()== null) {
				 UserDetails userDetails = userDetailsService.loadUserByUsername(email);
				 
				 // Validate user name and date expired
				 if(jwtService.isValidToken(token, userDetails)) {
					 
					 UsernamePasswordAuthenticationToken authenticationToken = 
							 new UsernamePasswordAuthenticationToken(email, null , userDetails.getAuthorities());
					 
					 authenticationToken.setDetails(
							 new WebAuthenticationDetailsSource()
							 .buildDetails(request));
					 
					 SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				 }
			}

			filterChain.doFilter(request, response);
        }catch(Exception ex) {
        	throw new RuntimeException(ex);
        }
	}
	
}

	
