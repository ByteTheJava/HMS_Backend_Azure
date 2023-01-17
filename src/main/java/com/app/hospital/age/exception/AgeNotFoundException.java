package com.app.hospital.age.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AgeNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public AgeNotFoundException(String errorMessage) {
		super(errorMessage);
	}

	public AgeNotFoundException(Throwable ex) {
		super(ex);
	}

	public AgeNotFoundException() {
		super();
	}
}
