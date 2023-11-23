package com.coffee.system.model.entity;

import java.util.Date;
import java.util.List;

import com.coffee.system.config.SysAuditing;
import com.coffee.system.config.security.model.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "import")
public class Import extends SysAuditing{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany
	private List<Material> materials;
	
	@ManyToOne
	private User user;
	
	private Date impDate;
	
	private long totalAmount; 
	
	private String status;
}
