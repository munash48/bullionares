package com.kalimagezi.billionareskb.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.HttpRequestMethodNotSupportedException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {
		ModelAndView mv = new ModelAndView("welcome");
		
		mv.addObject("title", "404-ERROR PAGE ");
		mv.addObject("errorDescription", "The page your looking for is not constructed on this server");
		mv.addObject("errorTitle", "Page not found");
		mv.addObject("modeErrorAccess", true);
		return mv;
	}
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public String httpRequestMethodNotSupportedException() {
		return "redirect:/perform-logout?session=ex";
	}
}
