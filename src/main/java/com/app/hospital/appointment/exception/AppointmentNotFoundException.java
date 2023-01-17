package com.app.hospital.appointment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AppointmentNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public AppointmentNotFoundException(String errorMessage) {
		super(errorMessage);
	}

	public AppointmentNotFoundException(Throwable ex) {
		super(ex);
	}

	public AppointmentNotFoundException() {
		super();
	}

}
