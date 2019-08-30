package com.springmvc.restful.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

	/**
	 *  该方法在目标方法之前被调用
	 *  若返回值为 true, 则继续调用后续的拦截器和目标方法
	 *  若返回值为 false, 则不会调用后续的拦截器和目标方法
	 * */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("[ MyInterceptor ] preHandle");
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	/**
	 *  调用目标方法之后，渲染视图之前被调用
	 * */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("[ MyInterceptor ] postHandle");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	/**
	 *  渲染视图之后被调用
	 * */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, 
			Exception ex) throws Exception {
		System.out.println("[ MyInterceptor ] afterCompletion");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
}
