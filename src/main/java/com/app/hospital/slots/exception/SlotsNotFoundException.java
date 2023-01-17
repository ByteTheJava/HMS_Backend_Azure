package com.app.hospital.slots.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SlotsNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public SlotsNotFoundException(String errorMessage) {
		super(errorMessage);
	}

	public SlotsNotFoundException(Throwable ex) {
		super(ex);
	}

	public SlotsNotFoundException() {
		super();
	}

}
