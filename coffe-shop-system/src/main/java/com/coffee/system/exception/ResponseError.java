package com.coffee.system.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseError {
	private String sysErrCode;
	private String status;
	private String errCode;
	private String message;
}
