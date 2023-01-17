package com.app.hospital.department.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DepartmentNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public DepartmentNotFoundException(String errorMessage) {
		super(errorMessage);
	}

	public DepartmentNotFoundException(Throwable ex) {
		super(ex);
	}

	public DepartmentNotFoundException() {
		super();
	}

}
