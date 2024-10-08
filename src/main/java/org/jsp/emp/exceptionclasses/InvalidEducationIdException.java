package org.jsp.emp.exceptionclasses;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
public class InvalidEducationIdException extends RuntimeException {
	String message;	
	public InvalidEducationIdException(String message) {
		this.message = message;
	}
    
	@Override
	public String getMessage() {
		
		return message;
	}
	
	

}
