package org.jsp.emp.exceptionhandler;

import org.jsp.emp.exceptionclasses.InvalidEducationIdException;
import org.jsp.emp.exceptionclasses.NoEducationFoundException;
import org.jsp.emp.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EducationExceptionHandler {
	
	@ExceptionHandler(InvalidEducationIdException.class)
	public ResponseEntity<?> invalidEducationIdException(InvalidEducationIdException e)
	{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value()).body(e.getMessage()).message("unable to find education details").build());
	}
	
	@ExceptionHandler(NoEducationFoundException.class)
	public ResponseEntity<?> noEducationFoundException(NoEducationFoundException e)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).message("no education details available").body(e.getMessage()).build());
	}

}
