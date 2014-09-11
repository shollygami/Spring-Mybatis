package com.costamar.app.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.costamar.app")
@EnableWebMvc
@Import({ WebInitializer.class, DispatcherConfiguration.class, DatabaseConfiguration.class  , InternationalizationConfiguration.class})
public class ApplicationConfiguration {}