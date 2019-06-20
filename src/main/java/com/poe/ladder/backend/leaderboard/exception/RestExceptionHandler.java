package com.poe.ladder.backend.leaderboard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;	

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NullPointerException.class)	
	protected ResponseEntity<Object> handleHttpMessageNotReadable(NullPointerException ex) {
		return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, "NullPointerException encountered during request.", ex));
	}

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

}