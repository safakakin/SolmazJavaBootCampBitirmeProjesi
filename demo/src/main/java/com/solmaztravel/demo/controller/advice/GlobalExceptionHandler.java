package com.solmaztravel.demo.controller.advice;


import com.solmaztravel.demo.exception.ExceptionResponse;
import com.solmaztravel.demo.exception.SolmazTravelException;
import com.solmaztravel.demo.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handle(UserNotFoundException exception) {
		//String message = messageSource.getMessage(exception.getMessage(), null, new Locale("tr"));
		return ResponseEntity.ok(new ExceptionResponse(exception.getMessage(), HttpStatus.BAD_REQUEST));
	}

	@ExceptionHandler(SolmazTravelException.class)
	public ResponseEntity<ExceptionResponse> handle(SolmazTravelException exception) {
		String message = messageSource.getMessage(exception.getKey(), null, new Locale("tr"));	
		return ResponseEntity.ok(new ExceptionResponse(message, HttpStatus.BAD_REQUEST));
	}

}
