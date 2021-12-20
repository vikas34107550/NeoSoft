package com.example.NeoSoft.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityException extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		
ExceptionResponse response=new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
return new ResponseEntity(response,HttpStatus.INTERNAL_SERVER_ERROR);

}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		
ExceptionResponse response=new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
return new ResponseEntity(response,HttpStatus.NOT_FOUND);

     }
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse response=new ExceptionResponse(new Date(), "Bean Valiation failed", ex.getBindingResult().toString());

		return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
	}
}
