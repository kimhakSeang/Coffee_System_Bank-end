package com.coffee.system.util;

import org.springframework.http.HttpStatus;

import com.coffee.system.exception.HttpStatusImpl;

public enum ErrorUtil {
	
    NOT_FOUND("001", HttpStatusImpl.NOT_FOUND, "NOT FOUND!"),
	INSERT_FAIL("002", HttpStatusImpl.INSERT_FAIL, "INSERT FAIL!"),
	UPDATE_FAIL("003", HttpStatusImpl.UPDATE_FAIL, "UPDATE FAIL!"),
	DELETE_FAIL("004", HttpStatusImpl.DELETE_FAIL, "DELETE FAIL!"),
	READY_EXIST("0005", HttpStatusImpl.BAD_REQUEST, "READY EXIST"),
	BAD_REQUEST("0006", HttpStatusImpl.BAD_REQUEST, "BAD REQUEST"),
	SERVER_ERROR("0007", HttpStatusImpl.INTERNAL_SERVER_ERROR, "INTERNAL SERVER ERROR"),
	DATA_ERROR("0008", HttpStatusImpl.BAD_REQUEST, "DATA ERROR"),
	WRONG_CREDENTAIL("0009", HttpStatusImpl.BAD_REQUEST, "WRONG CREDENTAIL"),
	ERROR_TOKEN("0010", HttpStatusImpl.BAD_REQUEST, "TOKEN INVALID")
	;
	
	private HttpStatusImpl httpStatus;
	private String errCode;
	private String message;
	
	private ErrorUtil(String code , HttpStatusImpl httpStatus, String message) {
		this.errCode = code;
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return HttpStatus.valueOf(httpStatus.value());
	}
	public void setHttpStatus(HttpStatusImpl httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorCodeMessage() {
		return "Error Code->"+errCode+"["+httpStatus.getReasonPhrase()+"]"+":"+message;
	}
}
