package com.coffee.system.config.security.model;


import java.util.Set;

import com.coffee.system.config.SysAuditing;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@Data
@Entity
@Table(name= "ROLE")
@AllArgsConstructor
@NoArgsConstructor
public class Role extends SysAuditing  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private RoleEnum role;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@Column(name = "permission")
	private Set<UserPermission> permission;
	
	private String useYN;
}