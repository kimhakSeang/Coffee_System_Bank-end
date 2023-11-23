package com.coffee.system.config.security.service.jwt;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UsernamePasswordJwtFilter /* extends UsernamePasswordAuthenticationFilter */{
//	private final AuthenticationManager authenticationManager ;
//	private JwtService jwtService= new JwtService();
//    private final EmailService emailService;
//    
//	@Override
//	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
//		 try {
//			 
//		    UserLogin requestLogin = new ObjectMapper().readValue(request.getInputStream(), UserLogin.class);
//		    
//		    Authentication authenticationToken = new UsernamePasswordAuthenticationToken(requestLogin.getEmail(), requestLogin.getPassword());
//			
//		    // Validate Email Verify
//		    if(!emailService.isVerify(requestLogin.getEmail())) {
//		    	throw new RuntimeException("Your email not yet verify!");
//		    }; 
//		    
//			Authentication authentication = authenticationManager.authenticate(authenticationToken);
//			return authentication;
//			
//		 } catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		}
//	}
//	
//	@Override
//	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
//		String token = jwtService.generateToken(authResult);
//			response.addHeader("Authorization",token);
//	}
}
