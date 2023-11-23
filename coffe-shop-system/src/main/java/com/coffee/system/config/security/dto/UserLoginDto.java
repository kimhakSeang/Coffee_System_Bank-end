package com.coffee.system.config.security.dto;

import java.util.Date;
import java.util.Set;

import com.coffee.system.config.security.model.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDto {
	private Integer userId;
    private String username;
  	private String password;
  	private Integer roleId;
  	private boolean accountNonExpired;
  	private boolean accountNonLocked;
  	private boolean credentialsNonExpired;
  	private boolean enabled;
	private String email;
	private Integer tell;
	private Date dob;
	private Gender gender;
	private String photoLink;
	private String statusYN;
	private Set<Integer> courseId; 
}
