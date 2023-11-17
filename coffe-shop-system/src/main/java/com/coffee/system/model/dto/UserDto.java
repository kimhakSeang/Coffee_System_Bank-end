package com.coffee.system.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class UserDto {
	private String userFirstName;
	private String userLastName;
	private String email;
	private String password;
	private String phoneNumber;
	private Integer roleId;
	private Date joinDate;
	private Date leaveDate;
	private String workYN;
	private String loation;
}
