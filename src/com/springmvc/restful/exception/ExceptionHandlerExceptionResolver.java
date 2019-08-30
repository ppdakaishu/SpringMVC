package com.springmvc.restful.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerExceptionResolver {

	@ExceptionHandler({NumberFormatException.class})
	public ModelAndView handlerNumberFormatException(Exception ex) {
		System.out.println("出现异常 ： [ NumberFormatException ] "  + ex);
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("exceptionMessage", ex);
		return mv;
	}
	
}
