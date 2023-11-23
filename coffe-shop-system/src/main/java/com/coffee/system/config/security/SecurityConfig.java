package com.coffee.system.config.security;


import org.springframework.context.annotation.Bean;
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
public class SecurityConfig {
//	private final UserDetailsService userDetailsService;
//	private final PasswordEncoder passwordEncoder;
//	private final AuthenticationConfiguration authenticationConfiguration;
//	private final EmailService emailService;
	
//    @Bean
//    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//    	http.authorizeHttpRequests(authz -> authz
//    		    .requestMatchers("/", "index.html", "css/**", "js/**", "/swagger-ui/index.html").permitAll()
//    		    .anyRequest()
//    		    .authenticated());
//
////    	http.csrf(csrf -> csrf.disable())
////    	          .authorizeHttpRequests(authz -> authz.requestMatchers("/","index.html","css/**","js/**").permitAll()
////    			  .anyRequest()
////    			  .authenticated());
//    	
//	
//        return http.build();
//    }
//    
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(getAuthenticationProvider());
//	}
//    
//	@Bean
//	AuthenticationProvider getAuthenticationProvider() {
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setUserDetailsService(userDetailsService);
//		provider.setPasswordEncoder(passwordEncoder);
//		return provider;
//	}
//	
//	@Bean
//	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//	    return authenticationConfiguration.getAuthenticationManager();
//	}
}
