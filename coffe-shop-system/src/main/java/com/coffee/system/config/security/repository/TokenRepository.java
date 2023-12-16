package com.coffee.system.config.security.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.coffee.system.config.security.model.Token;

public interface TokenRepository  extends JpaRepository<Token, Integer> {
	
	Optional<Token> findEmailTokenByToken(String token);
  	@Query(value=  "SELECT M.* 				         	 \r\n"
			     + "  FROM TOKEN M					     \r\n"
			     + " INNER JOIN USERS U                  \r\n"
			     + "    ON M.USER_ID = U.ID             \r\n"
	             + " WHERE U.EMAIL = :email              \r\n", nativeQuery = true)
	Optional<Token> findEmailTokenByEmail(@Param("email")String email);
	
}
