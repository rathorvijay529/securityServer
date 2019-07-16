/*package com.apiErrorHandling;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.entity.ErrorResponse;

import javassist.NotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{

	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> defaultExceptionHandler(NotFoundException  notFoundException,HttpHeaders headers, HttpStatus status, WebRequest request) {

		
		
		
		return new ResponseEntity<>(new ErrorResponse(status.NOT_FOUND,status.NOT_FOUND,), response.getStatus());
    }
}
*/