package com.coffee.system.model.user;

public enum RoleEnum {
	  USER("001", "Normal User")
	, ADMIN("002", "Normal User")
	, CASHIER("003", "Normal User")
	, SERVICE("004", "Normal User")
	, CSUTOMER("010", "Normal User");
	
	private String code, detail;
	
	RoleEnum(String code, String detail){
		this.code = code;
		this.detail = detail;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
