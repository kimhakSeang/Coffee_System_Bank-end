package com.coffee.system.model.user;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
	
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

}
