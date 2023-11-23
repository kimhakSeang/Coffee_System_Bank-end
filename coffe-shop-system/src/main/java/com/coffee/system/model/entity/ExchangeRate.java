package com.coffee.system.model.entity;

import java.util.Date;

import com.coffee.system.config.SysAuditing;
import com.coffee.system.util.CurrencyEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
@Entity
@Table(name = "echange_rate")
public class ExchangeRate extends SysAuditing{
	@Id
	@GeneratedValue
	
	private int id;
	private Date exchgDate;
	
	@Enumerated(EnumType.ORDINAL)
	private CurrencyEnum currencyEnum;
	
	private double rate;
}

