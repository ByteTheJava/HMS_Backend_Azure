package com.app.hospital.gender.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class GenderNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public GenderNotFoundException(String errorMessage) {
		super(errorMessage);
	}

	public GenderNotFoundException(Throwable ex) {
		super(ex);
	}

	public GenderNotFoundException() {
		super();
	}

}
