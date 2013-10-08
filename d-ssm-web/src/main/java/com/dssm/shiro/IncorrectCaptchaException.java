package com.dssm.shiro;

import org.apache.shiro.authc.AuthenticationException;

public class IncorrectCaptchaException extends AuthenticationException {

	private static final long serialVersionUID = 5226034648400933030L;

	/**
     * Creates a new IncorrectCaptchaException.
     */
    public IncorrectCaptchaException() {
        super();
    }

    /**
     * Constructs a new IncorrectCaptchaException.
     *
     * @param message the reason for the exception
     */
    public IncorrectCaptchaException(String message) {
        super(message);
    }

    /**
     * Constructs a new IncorrectCaptchaException.
     *
     * @param cause the underlying Throwable that caused this exception to be thrown.
     */
    public IncorrectCaptchaException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new IncorrectCaptchaException.
     *
     * @param message the reason for the exception
     * @param cause   the underlying Throwable that caused this exception to be thrown.
     */
    public IncorrectCaptchaException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
