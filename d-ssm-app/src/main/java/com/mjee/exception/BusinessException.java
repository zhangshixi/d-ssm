package com.mjee.exception;

/**
 * Business exception.
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 3827556303627625478L;

	public BusinessException() {
		super();
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}
    
}
