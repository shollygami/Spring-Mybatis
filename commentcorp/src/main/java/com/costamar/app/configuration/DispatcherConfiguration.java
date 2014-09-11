package com.costamar.app.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.costamar.app.utils.AutorizadorInterceptor;


@Configuration
@Import({ ThymeleafConfiguration.class })
public class DispatcherConfiguration extends WebMvcConfigurerAdapter {

	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor( new AutorizadorInterceptor());
//	}
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		registry.addResourceHandler("/html/**").addResourceLocations("/html/");
		registry.addResourceHandler("/img/**").addResourceLocations("/img/");
		registry.addResourceHandler("/fonts/**").addResourceLocations("/fonts/");
	}
}