package com.app.hospital.doctor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DoctorNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public DoctorNotFoundException(String errorMessage) {
		super(errorMessage);
	}

	public DoctorNotFoundException(Throwable ex) {
		super(ex);
	}

	public DoctorNotFoundException() {
		super();
	}

}
