package com.costamar.app.configuration;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.costamar.app.utils.JsessionIdAvoiderFilter;

@Configuration
public class WebInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(ApplicationConfiguration.class);
		ctx.setServletContext(servletContext);

		Dynamic servlet = servletContext.addServlet("CommentCoorp", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		
		FilterRegistration.Dynamic sessionIDAvoider = 
				servletContext.addFilter("sessionIDAvoider", JsessionIdAvoiderFilter.class);
		sessionIDAvoider.addMappingForUrlPatterns(null, false, "/*");
	}
}