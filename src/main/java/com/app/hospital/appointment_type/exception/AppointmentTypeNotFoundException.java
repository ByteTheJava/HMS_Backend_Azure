package com.app.hospital.appointment_type.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AppointmentTypeNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public AppointmentTypeNotFoundException(String errorMessage) {
		super(errorMessage);
	}

	public AppointmentTypeNotFoundException(Throwable ex) {
		super(ex);
	}

	public AppointmentTypeNotFoundException() {
		super();
	}

}
