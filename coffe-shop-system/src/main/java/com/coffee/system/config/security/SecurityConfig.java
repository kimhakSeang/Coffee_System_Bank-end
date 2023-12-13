package com.coffee.system.config.security;


import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.coffee.system.config.security.service.EmailService;
import com.coffee.system.config.security.service.jwt.JwtAuthTokenVerify;
import com.coffee.system.config.security.service.jwt.UsernamePasswordJwtFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationConfiguration authenticationConfiguration;
	private final EmailService emailService;
	
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	
    	
    	 http.cors(t -> t.disable());
    	 http.csrf(csrf->csrf.disable());
    	 
    	 http
    	  .authorizeHttpRequests(auth -> {
    		  auth.anyRequest().permitAll();
    	  }
//    	  auth.requestMatchers(HttpMethod.POST,"/user_login").permitAll();
//    		  .requestMatchers("/swagger-ui/index.html").permitAll()
//	          .requestMatchers("/email/confirm").permitAll()
//	          .requestMatchers(HttpMethod.POST, "/user/add").permitAll() 
//	          .requestMatchers(HttpMethod.GET, "/role/get/*").permitAll() 
//	          .requestMatchers("/user_login",HttpMethod.POST).permitAll()
//	          .requestMatchers(HttpMethod.GET, "/category/get/**").permitAll()
//	          .anyRequest().authenticated()
//    	  auth.an
	          );
    	 http.addFilter(new UsernamePasswordJwtFilter(authenticationManager(authenticationConfiguration), emailService));
    	 http.addFilterAfter( new JwtAuthTokenVerify(userDetailsService),UsernamePasswordJwtFilter.class );
    	 http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
         
	
    	return http.build();
    }
	
	 
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(getAuthenticationProvider());
	}
    
	@Bean
	AuthenticationProvider getAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder);
		return provider;
	}
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
	    CorsConfiguration configuration = new CorsConfiguration();
	    configuration.setAllowedOrigins(Arrays.asList("*"));
	    configuration.setAllowedMethods(Arrays.asList("*"));
	    configuration.setAllowedHeaders(Arrays.asList("*"));
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", configuration);
	    return source;
	}
}
