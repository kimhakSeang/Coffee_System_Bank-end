package com.coffee.system.model.system;

import java.util.Date;
import java.util.List;

import com.coffee.system.model.user.User;

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
public class Import {
	
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
