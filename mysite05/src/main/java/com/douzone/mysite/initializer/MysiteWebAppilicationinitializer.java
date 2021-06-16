package com.douzone.mysite.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.douzone.mysite.config.AppConfig;
import com.douzone.mysite.config.WebConfig;

public class MysiteWebAppilicationinitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
     //Root AppilctionContext's Configuration Class
		return new Class <?>[] {AppConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		//Web Application Context's Configuration Class 
		return new Class <?>[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// Dispatcher  Servlet Mapping URL
		return new String[] {"/"} ;
	}

	
}
