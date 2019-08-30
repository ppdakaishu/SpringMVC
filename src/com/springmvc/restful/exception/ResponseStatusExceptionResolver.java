package com.springmvc.restful.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.FORBIDDEN, reason="val不合法")
public class ResponseStatusExceptionResolver extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
