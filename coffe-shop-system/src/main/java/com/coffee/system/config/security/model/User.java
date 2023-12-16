package com.coffee.system.config.security.model;

import java.util.Date;

import com.coffee.system.config.SysAuditing;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
@Entity
@Table(name = "users")
public class User extends SysAuditing{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String userFirstName;

	private String userLastName;
	
	private String email;
	
	private String password;
	
	private String phoneNumber;
	
	@OneToOne
	private Role role;

	private Date joinDate;

	private Date leaveDate;

	private String workYN;

	private String loation;

	private String photoLink;

}
