package com.neptune.crms.exceptions;

public abstract class AbstractException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	// protected final ErrorMessage errorMessage;

	public AbstractException(String errorMessage) {
		super(errorMessage);
		// this.errorMessage = errorMessage;
	}

	public AbstractException(String errorMessage, Throwable cause) {
		super(cause);
		// this.errorMessage = errorMessage;
	}

}
