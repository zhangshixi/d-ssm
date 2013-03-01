package com.mjee.app.exception;

public class NotExistedException extends BusinessException {

    private static final long serialVersionUID = 3460175631072188403L;

    public NotExistedException() {
        super();
    }

    public NotExistedException(String message) {
        super(message);
    }

    public NotExistedException(Throwable cause) {
        super(cause);
    }
    
    public NotExistedException(String message, Throwable cause) {
        super(message, cause);
    }

}
