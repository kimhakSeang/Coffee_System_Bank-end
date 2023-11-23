package com.coffee.system.model.entity;

import java.util.Date;
import java.util.List;

import com.coffee.system.config.SysAuditing;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "payment")
public class Payment extends SysAuditing{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToMany
	private List<PreOrder> orders;
	
	@ManyToOne
	private ExchangeRate exchangeRate;
	
	@ManyToOne
	private Discount discount;
	
	private Date paymentDate;
}
