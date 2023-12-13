package com.coffee.system.model.dto;

import java.util.Date;

import com.coffee.system.util.CurrencyEnum;

import lombok.Data;

@Data
public class ExchangeRateDto {
	private Date exchgDate;
	private CurrencyEnum currencyEnum;
	private double rate;
}

