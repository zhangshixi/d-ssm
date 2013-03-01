package com.mjee.app.exception;

/**
 * System exception.
 */
public class SystemException extends RuntimeException {

    private static final long serialVersionUID = 5140013975703590938L;

	public SystemException() {
		super();
	}

	public SystemException(String message) {
		super(message);
	}

	public SystemException(Throwable cause) {
		super(cause);
	}
	
	public SystemException(String message, Throwable cause) {
		super(message, cause);
	}
    
}
