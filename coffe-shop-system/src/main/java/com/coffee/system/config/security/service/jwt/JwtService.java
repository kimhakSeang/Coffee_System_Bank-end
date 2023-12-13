package com.coffee.system.config.security.service.jwt;


import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {
	
//	@Value("${value.secret_key}") 
	private String SECRET_KEY = "Password123456789abcdefghijklmn2fsdfsdfsdhfg2434hfopqrshgfh5345ASSAfghg";
	
	public Claims extractAllCliams(String token) {
		return Jwts.parserBuilder()
				.setSigningKey( getSignInKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
	
	public String generateToken( Authentication authResult) {
		System.out.println(">>>>>>>>>>>>>>>> Start generate token!");
		return Jwts.builder()
				.setSubject(authResult.getName())
				.claim("authorities", authResult.getAuthorities())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24)))
				.signWith(getSignInKey())
				.compact();
	}
	
	public <T> T extractClaim(String token, Function<Claims, T> cliamResolver){
		Claims extractAllCliams = extractAllCliams(token);
		return  cliamResolver.apply(extractAllCliams);
	}
	
	public boolean isValidToken(String token, UserDetails userDetails) {
		return getUsername(token).equals(userDetails.getUsername()) 
				&& dateExpired(token).getTime()>new Date().getTime();
	}
	
	public Date dateExpired(String token) {
		return extractClaim(token, Claims::getExpiration);
	}
	
	public String getUsername(String token) {
		return extractClaim(token , Claims::getSubject);
	}  
	
	private Key getSignInKey() {
	    byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
	    return Keys.hmacShaKeyFor(keyBytes);
	}
	
	
}
