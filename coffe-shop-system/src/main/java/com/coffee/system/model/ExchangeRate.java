package com.coffee.system.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "echange_rate")
public class ExchangeRate {
	@Id
	@GeneratedValue
	private int id;
	
	private Date date;
//	private 
	private double rate;
	@OneToMany
	private List<Payment> payments;
}

