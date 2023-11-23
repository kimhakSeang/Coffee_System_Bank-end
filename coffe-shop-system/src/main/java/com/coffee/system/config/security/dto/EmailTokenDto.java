package com.coffee.system.config.security.dto;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailTokenDto {

	private String token;
	private boolean enable;
	private int userId;
	private LocalDateTime createdAt;
	private LocalDateTime expiredAt;
	private LocalDateTime confirmedAt;
	
	EmailTokenDto(int userId){
		this.userId = userId;
	}
}
