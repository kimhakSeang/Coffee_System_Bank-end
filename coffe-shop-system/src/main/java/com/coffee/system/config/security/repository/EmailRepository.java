package com.coffee.system.config.security.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.coffee.system.config.security.model.EmailToken;

public interface EmailRepository  extends JpaRepository<EmailToken, Integer> {
	
	Optional<EmailToken> findEmailTokenByToken(String token);
	@Query(value=  "SELECT M.* 						\r\n"
				 + "  FROM TOKEN M					\r\n"
				 + " INNER JOIN USER_LOGIN UL		\r\n"
				 + "    ON M.USER_LOGIN_ID = UL.id	\r\n"
				 + " WHERE UL.email = :email			"
				 , nativeQuery = true)
	Optional<EmailToken> findEmailTokenByEmail(@Param("email")String email);
	
}
