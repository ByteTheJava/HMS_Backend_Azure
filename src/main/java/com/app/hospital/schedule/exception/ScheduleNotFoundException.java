package com.app.hospital.schedule.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ScheduleNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public ScheduleNotFoundException(String errorMessage) {
		super(errorMessage);
	}

	public ScheduleNotFoundException(Throwable ex) {
		super(ex);
	}

	public ScheduleNotFoundException() {
		super();
	}

}
