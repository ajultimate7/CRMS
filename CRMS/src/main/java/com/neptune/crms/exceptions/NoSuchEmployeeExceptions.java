package com.neptune.crms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT)
public class NoSuchEmployeeExceptions extends AbstractException {

	public NoSuchEmployeeExceptions(String message) {
		super(message);
	}

}
