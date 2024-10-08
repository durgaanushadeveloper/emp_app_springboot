package org.jsp.emp.exceptionhandler;

import org.jsp.emp.exceptionclasses.NoAddressesFoundException;
import org.jsp.emp.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AddressExceptionHandler {
	
	@ExceptionHandler(NoAddressesFoundException.class)
	public ResponseEntity<?> noAddressFoundExceptionHandler(NoAddressesFoundException e)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).message("no addresses found").body(e.getMessage()).build());
	}

}
