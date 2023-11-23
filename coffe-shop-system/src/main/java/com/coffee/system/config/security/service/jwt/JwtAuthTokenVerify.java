package com.coffee.system.config.security.service.jwt;


import org.springframework.context.annotation.Configuration;

@Configuration
//@RequiredArgsConstructor
public class JwtAuthTokenVerify /* extends OncePerRequestFilter */ {

//	private final UserDetailsService userDetailsService;
//	private JwtService jwtService= new JwtService();
	
	/*
	 * @Override protected void doFilterInternal(HttpServletRequest request,
	 * HttpServletResponse response, FilterChain filterChain)throws
	 * ServletException, IOException {
	 * 
	 * final String authHeader = request.getHeader("Authorization");
	 * 
	 * if(authHeader == null || !authHeader.startsWith("Bearer ")) {
	 * filterChain.doFilter(request, response); // throw new
	 * RuntimeException("Token Invalid!"); return; } String token =
	 * authHeader.replace("Bearer ", "");
	 * 
	 * try { Claims body = jwtService.extractAllCliams(token); String email =
	 * body.getSubject();
	 * 
	 * if(email != null && SecurityContextHolder.getContext().getAuthentication()==
	 * null) { UserDetails userDetails =
	 * userDetailsService.loadUserByUsername(email);
	 * 
	 * // Validate username and date expired if(jwtService.isValidToken(token,
	 * userDetails)) {
	 * 
	 * UsernamePasswordAuthenticationToken authenticationToken = new
	 * UsernamePasswordAuthenticationToken(email, null ,
	 * userDetails.getAuthorities());
	 * 
	 * authenticationToken.setDetails( new WebAuthenticationDetailsSource()
	 * .buildDetails(request));
	 * 
	 * SecurityContextHolder.getContext().setAuthentication(authenticationToken); }
	 * } filterChain.doFilter(request, response);
	 * 
	 * }catch(Exception ex) { throw new RuntimeException(ex); }
	 * 
	 * }
	 */
}

	
