package com.dssm.exception;

import com.mtoolkit.util.StringUtil;

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
    
	public BusinessException(String message, Object... params) {
	    super(StringUtil.replaceHolderArgs(message, params));
	}
	
	public BusinessException(Throwable cause, String message, Object... params) {
		super(StringUtil.replaceHolderArgs(message, params), cause);
	}
	
}
