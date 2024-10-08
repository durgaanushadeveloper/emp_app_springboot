package org.jsp.emp.exceptionclasses;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
public class NoAddressesFoundException extends RuntimeException {
	private String message;

	public NoAddressesFoundException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}

}
