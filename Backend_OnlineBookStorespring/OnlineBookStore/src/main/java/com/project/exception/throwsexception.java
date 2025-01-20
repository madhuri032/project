package com.project.exception;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;






@ControllerAdvice
public class throwsexception {
	
	private static final Logger log = LoggerFactory.getLogger(throwsexception.class);
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> valditaionException(MethodArgumentNotValidException e)
	{
		
		log.info("I am in MethodArgumentNotValidException exception class--"+e);
		log.error("I am in MethodArgumentNotValidException exception class--"+e);
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(SQLException.class)
	public ResponseEntity<String> dbrelatedException(SQLException e)
	{
		log.info("I am in sql Exceptiom exception class--"+e);
		log.error("I am in  sql Exception exception class--"+e);
		
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> commonException(Exception e)
	{
		log.info("I am in common Exceptiom exception class--"+e.toString());
		log.error("I am in  common Exception exception class--"+e);
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
