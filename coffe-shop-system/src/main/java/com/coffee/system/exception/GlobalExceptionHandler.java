package com.coffee.system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.coffee.system.util.ErrorUtil;

import io.jsonwebtoken.security.SignatureException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(RuntimeExceptionImpl.class)
	public ResponseEntity<?> handleHttpClientError(RuntimeExceptionImpl e){
		ResponseError errorResponse = new ResponseError(  e.getErrUtil().getHttpStatus().value()+""
														, e.getErrUtil().getHttpStatus().getReasonPhrase()
														, e.getErrUtil().getErrCode()
														, e.getMessage());
//		return ResponseEntity.status(e.getErrUtil().getHttpStatus()).body(errorResponse);
		return ResponseEntity.ok(errorResponse);
	}
	
	@ExceptionHandler(value = { AuthenticationException.class })
	public ResponseEntity<?> doubleException(BadCredentialsException e) {
		ResponseError messageException = new ResponseError(  
				"500"
				, ErrorUtil.ERROR_TOKEN.getMessage()
				, ErrorUtil.ERROR_TOKEN.getErrCode()
				, e.getMessage());
		return ResponseEntity.ok(messageException);
	}
	
	@ExceptionHandler(value = { SignatureException.class })
	public ResponseEntity<?> doubleException(SignatureException e) {
		ResponseError messageException = new ResponseError(  
				"500"
				, ErrorUtil.ERROR_TOKEN.getMessage()
				, ErrorUtil.ERROR_TOKEN.getErrCode()
				, e.getMessage());
		return ResponseEntity.ok(messageException);
	}
	
	@ExceptionHandler(value = { IllegalArgumentException.class })
	public ResponseEntity<?> illegalArgumentException(IllegalArgumentException e) {
		ResponseError messageException = new ResponseError(  
				 HttpStatus.BAD_REQUEST.getReasonPhrase()
				, ErrorUtil.BAD_REQUEST.getMessage()
				, ErrorUtil.BAD_REQUEST.getErrCode()
				, e.getMessage());
		return ResponseEntity.ok(messageException);
	}

}