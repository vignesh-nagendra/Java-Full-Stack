package com.infy.EmployeeDetails.exception;


import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infy.EmployeeDetails.dto.ErrorMessage;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception ex) {
		return ex.getMessage();
	}
	
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<ErrorMessage> exceptionHandler2(EmployeeException ex) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
	
		@ExceptionHandler(ConstraintViolationException.class)
		public ResponseEntity<ErrorMessage> pathExceptionHandler(ConstraintViolationException exception) {
			ErrorMessage errorInfo = new ErrorMessage();
			errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
			String errorMsg = exception.getConstraintViolations().stream().map(x -> x.getMessage())
					.collect(Collectors.joining(", "));
			errorInfo.setMessage(errorMsg);
			return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
		}

}
