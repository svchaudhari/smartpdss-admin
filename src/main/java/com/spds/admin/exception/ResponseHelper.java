package com.spds.admin.exception;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseHelper {
	public ResponseEntity<Object> createErrorResponse(HttpHeaders headers, HttpStatusCode status,Map<String,String> fieldError, String code,String message)
	{
		Error error=new Error();
		error.setCode(code);
		error.setMessage(message);
		error.setFields(fieldError);
		
		return new ResponseEntity<>(error,headers,status);
	}

}
