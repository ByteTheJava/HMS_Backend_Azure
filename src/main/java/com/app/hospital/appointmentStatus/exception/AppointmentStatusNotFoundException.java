package com.app.hospital.appointmentStatus.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AppointmentStatusNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public AppointmentStatusNotFoundException(String errorMessage) {
		super(errorMessage);
	}

	public AppointmentStatusNotFoundException(Throwable ex) {
		super(ex);
	}

	public AppointmentStatusNotFoundException() {
		super();
	}

}
