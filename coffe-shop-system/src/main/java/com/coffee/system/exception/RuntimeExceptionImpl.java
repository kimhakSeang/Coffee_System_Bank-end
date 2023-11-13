package com.coffee.system.exception;

import com.coffee.system.util.ErrorUtil;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
public class RuntimeExceptionImpl extends RuntimeException{ 
	private ErrorUtil errUtil;
	private String message;
	public RuntimeExceptionImpl(ErrorUtil errUtil) {
		this.errUtil= errUtil;
	}
	public RuntimeExceptionImpl(ErrorUtil errUtil, String message) {
		this.errUtil = errUtil;
		this.message = message;
	}
} 