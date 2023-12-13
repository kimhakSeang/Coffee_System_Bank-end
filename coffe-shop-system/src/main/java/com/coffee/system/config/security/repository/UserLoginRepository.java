package com.coffee.system.config.security.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coffee.system.config.security.model.EmailToken;
import com.coffee.system.config.security.model.RequestLogin;

public interface UserLoginRepository extends JpaRepository<RequestLogin, Integer>{
	Optional<EmailToken> findEmailTokenByToken(String token);
	@Query(value=  "SELECT U.*							\r\n"
				 + "  FROM USER_LOGIN M					\r\n"
				 + " INNER JOIN USERS U					\r\n"
				 + "    ON U.ID = M.USER_ID				\r\n"
				 + " WHERE U.email = :email					"
				 , nativeQuery = true)
	Optional<RequestLogin> getUserRequestLoginByEmail(String email);
}
