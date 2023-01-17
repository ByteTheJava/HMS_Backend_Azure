package com.app.hospital.call.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CallStatusNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public CallStatusNotFoundException(String errorMessage) {
		super(errorMessage);
	}

	public CallStatusNotFoundException(Throwable ex) {
		super(ex);
	}

	public CallStatusNotFoundException() {
		super();
	}

}
