package com.coffee.system.model.entity;

import java.util.List;

import com.coffee.system.config.SysAuditing;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pre_order")
public class PreOrder extends SysAuditing{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany
	private List<Customer> customers;
	
	@ManyToMany
	private List<Item> items;
	
}
