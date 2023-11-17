package com.coffee.system.model.system;

import java.util.Date;

import com.coffee.system.util.CurrencyEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "echange_rate")
public class ExchangeRate {
	@Id
	@GeneratedValue
	
	private int id;
	private Date exchg_date;
	
	@Enumerated(EnumType.ORDINAL)
	private CurrencyEnum currencyEnum;
	
	private double rate;
}

