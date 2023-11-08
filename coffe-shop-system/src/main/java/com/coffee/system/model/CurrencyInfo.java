package com.coffee.system.model;

public enum CurrencyInfo {
	
	USD(1, "USD", "$"),
	KHR(1, "USD", "៛"),
	EUR(1, "USD", "€"),
	VND(1, "USD", "₫"),
	THB(1, "THB", "฿"),
	IDR(1, "USD", "Rp");
	
	private int code;
	private String name, represent;
	
	CurrencyInfo(int code, String name , String represent){
		this.code = code;
		this.name = name;
		this.represent = represent;
	}
    
	public Integer getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public String getRepInteger() {
		return represent;
	}
}