package com.costamar.app.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//		String uri = request.getRequestURI();
		
//		if(uri.contains("login")
//				||
//				uri.endsWith("") ||
//				uri.contains("")
//				) {
//			return true;
//		}
		
		if(request.getSession().getAttribute("loginUser")!=null){
			return true;
		}else{
			response.sendRedirect("/");
			return false;
		}
		
	}
	
}
