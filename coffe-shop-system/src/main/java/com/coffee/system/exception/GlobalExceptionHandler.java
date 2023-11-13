package com.coffee.system.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(RuntimeExceptionImpl.class)
	public ResponseEntity<?> handleHttpClientError(RuntimeExceptionImpl e){
		ResponseError errorResponse = new ResponseError(  e.getErrUtil().getHttpStatus().value()+""
														, e.getErrUtil().getHttpStatus().getReasonPhrase()
														, e.getErrUtil().getErrCode()
														, e.getMessage());
		return ResponseEntity.status(e.getErrUtil().getHttpStatus()).body(errorResponse);
	}

}