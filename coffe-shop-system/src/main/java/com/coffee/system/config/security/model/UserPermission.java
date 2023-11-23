package com.coffee.system.config.security.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name= "permission")
@AllArgsConstructor
@NoArgsConstructor
public class UserPermission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String permission;
	private String detail;
}
