package com.coffee.system.model.entity;

import com.coffee.system.config.SysAuditing;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
@Entity
@Table(name = "category")
public class Category extends SysAuditing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
    private String name;
    
}
