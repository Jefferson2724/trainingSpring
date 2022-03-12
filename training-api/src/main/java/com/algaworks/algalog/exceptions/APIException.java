package com.algaworks.algalog.exceptions;

import org.springframework.http.HttpStatus;
import org.slf4j.Logger;

public class APIException extends RuntimeException {
	
	private static final long serialVersionUID = 2757443381641621979L;

	private Logger log;
	private HttpStatus statusCode;
	
	public APIException() {
		this(null);
	}
	
	public APIException(String message) {
		this(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public APIException(String message, HttpStatus httpStatus) {
		this(message, httpStatus, null);
	}

	public APIException(String message, HttpStatus httpStatus, Logger logger) {
		this(message, httpStatus, logger, null);
	}

	public APIException(String message, HttpStatus httpStatus, Logger logger, Throwable cause) {
		super(message, cause);
		this.log = logger;
		this.statusCode = httpStatus;
		if (this.log != null) {
			this.log.error("{} {} {}", this.statusCode, message, cause);
		}
	}
	
	public HttpStatus getStatusCode() {
		return statusCode;
	}

}
