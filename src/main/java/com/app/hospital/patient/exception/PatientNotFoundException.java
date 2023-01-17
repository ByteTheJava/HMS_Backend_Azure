package com.app.hospital.patient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PatientNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public PatientNotFoundException(String errorMessage) {
		super(errorMessage);
	}

	public PatientNotFoundException(Throwable ex) {
		super(ex);
	}

	public PatientNotFoundException() {
		super();
	}

}
