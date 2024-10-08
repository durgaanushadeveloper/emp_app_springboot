package org.jsp.emp.exceptionhandler;
import java.sql.SQLIntegrityConstraintViolationException;

import org.jsp.emp.exceptionclasses.InvalidCredentialsException;
import org.jsp.emp.exceptionclasses.InvalidEmployeeIdException;
import org.jsp.emp.exceptionclasses.NoActiveEmployeeFoundException;
import org.jsp.emp.exceptionclasses.NoEmployeeFoundException;
import org.jsp.emp.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExceptionHandler
{
	
	@ExceptionHandler(NoActiveEmployeeFoundException.class)
	public ResponseEntity<?> noActiveEmployeeFoundExceptionHandler(NoActiveEmployeeFoundException e)
	{
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).message("No Active Employee found").body(e.getMessage()).build());
	}
	@ExceptionHandler(InvalidEmployeeIdException.class)
	public ResponseEntity<?> invalidEmployeeIdExceptionHandler(InvalidEmployeeIdException e)
	{
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).message("Invalid Employee id").body(e.getMessage()).build());
	}
	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<?> invalidCredentialExceptionHandler(InvalidCredentialsException e)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).message("Invalid Employee Credentials").body(e.getMessage()).build());
	}
	
	@ExceptionHandler(NoEmployeeFoundException.class)
	public ResponseEntity<?> noEmployeeFoundException(NoEmployeeFoundException e)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).message("no employee found").body(e.getMessage()).build());
	}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<?> sQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e)
	{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value()).message("duplicate employee or phone").body(e.getMessage()).build());
	}
	
	
	

}
