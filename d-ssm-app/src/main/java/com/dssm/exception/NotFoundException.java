package com.dssm.exception;

import com.mtoolkit.util.StringUtil;

/**
 * 404 not found exception.
 * 
 * @author Michael
 */
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 3460175631072188403L;

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }
    
    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(String message, Object... params) {
        super(StringUtil.replaceHolderArgs(message, params));
    }
    
    public NotFoundException(Throwable cause, String message, Object... params) {
		super(StringUtil.replaceHolderArgs(message, params), cause);
	}
    
}
