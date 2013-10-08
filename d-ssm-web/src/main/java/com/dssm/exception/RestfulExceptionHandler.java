package com.dssm.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestfulExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler({
		SystemException.class,
		BusinessException.class,
		NotFoundException.class
	})
	protected ResponseEntity<Object> handleExceptions(Exception ex, WebRequest request) {
		HttpHeaders headers = new HttpHeaders();

		if (ex instanceof SystemException) {
			HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
			return handleSystemException((SystemException) ex, headers, status, request);
		}
		else if (ex instanceof BusinessException) {
			HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
			return handleBusinessException((BusinessException) ex, headers, status, request);
		}
		else if (ex instanceof NotFoundException) {
			HttpStatus status = HttpStatus.NOT_FOUND;
			return handleNotFoundException((NotFoundException) ex, headers, status, request);
		}
		else {
			logger.warn("Unknown exception type: " + ex.getClass().getName());
			HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
			return handleExceptionInternal(ex, ex.getMessage(), headers, status, request);
		}
	}
	
	protected ResponseEntity<Object> handleSystemException(SystemException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		Throwable body = ex.getCause();
		return handleExceptionInternal(ex, body, headers, status, request);
	}
	
	protected ResponseEntity<Object> handleBusinessException(BusinessException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		String body = ex.getMessage();
		return handleExceptionInternal(ex, body, headers, status, request);
	}
	
	protected ResponseEntity<Object> handleNotFoundException(NotFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		String body = request.getDescription(false) + " <br/> " + ex.getMessage();
		return handleExceptionInternal(ex, body, headers, status, request);
	}
	
}
