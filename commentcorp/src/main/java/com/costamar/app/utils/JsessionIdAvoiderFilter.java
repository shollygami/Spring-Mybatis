package com.costamar.app.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class JsessionIdAvoiderFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		boolean allowFilterChain = redirectToAvoidJsessionId((HttpServletRequest)req, (HttpServletResponse)res);
		if(allowFilterChain)
			chain.doFilter(req, res);
	}

	public static boolean redirectToAvoidJsessionId(HttpServletRequest req, HttpServletResponse res) {
		HttpSession s = req.getSession();
		if (s.isNew()) {
			if (!(req.isRequestedSessionIdFromCookie() && req.isRequestedSessionIdFromURL())) {
				//String qs = req.getQueryString();
				String requestURI = req.getRequestURI();
				try {
					res.sendRedirect(requestURI); //+ "?" + qs
					return false;
				} catch (IOException e) {
					System.out.println("Error en el filter : " + e.getMessage());
				}
			}
		}
		return true;
	}
	
	public void init(FilterConfig arg0) throws ServletException { }
	public void destroy() { }
}