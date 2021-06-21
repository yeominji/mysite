package com.douzone.mysite.config;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.douzone.mysite.security.AuthInterceptor;
import com.douzone.mysite.security.AuthUserHandlerMethodArgumentResolver;
import com.douzone.mysite.security.LoginInterceptor;
import com.douzone.mysite.security.LogoutInterceptor;
@SpringBootConfiguration
@PropertySource("classpath:com/douzone/mysite/config/Webconfig.properties")


public class WebConfig implements WebMvcConfigurer {
	
	@Autowired
	private Environment env;
	
	
	// Argument Resolver
		@Bean
		public HandlerMethodArgumentResolver handlerMethodArgumentResolver() {
			return new AuthUserHandlerMethodArgumentResolver();
		}

		@Override
		public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
			argumentResolvers.add(handlerMethodArgumentResolver());
		}
		
		// Interceptors
		@Bean
		public HandlerInterceptor loginInterceptor() {
			return new LoginInterceptor();
		}

		@Bean
		public HandlerInterceptor logoutInterceptor() {
			return new LogoutInterceptor();
		}

		@Bean
		public HandlerInterceptor authInterceptor() {
			return new AuthInterceptor();
		}

		@Override
		public void addInterceptors(InterceptorRegistry registry) {
			registry
				.addInterceptor(loginInterceptor())
				.addPathPatterns(env.getProperty("security.auth-url"));
			
			registry
				.addInterceptor(logoutInterceptor())
				.addPathPatterns(env.getProperty("security.logout"));
			
			registry
				.addInterceptor(authInterceptor())
				.addPathPatterns("/**")
				.excludePathPatterns("/user/auth")
				.excludePathPatterns(env.getProperty("security.auth-url"))
				.excludePathPatterns(env.getProperty("security.logout"))
				.excludePathPatterns("/assets/**");
		}
		
		// Message Converters
		@Bean
		public StringHttpMessageConverter stringHttpMessageConverter() {
			StringHttpMessageConverter messageConverter = new StringHttpMessageConverter();  
			messageConverter.setSupportedMediaTypes(
				Arrays.asList(
					new MediaType("text", "html", Charset.forName("utf-8"))
				)
			);
			return messageConverter;
		}
		
		@Bean
		public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
			Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()
				.indentOutput(true)
				.dateFormat(new SimpleDateFormat("yyyy-mm-dd"));
			
			MappingJackson2HttpMessageConverter messageConverter
				= new MappingJackson2HttpMessageConverter(builder.build());
			messageConverter.setSupportedMediaTypes(
				Arrays.asList(
					new MediaType("application", "json", Charset.forName("utf-8"))	
				)
			);
			return messageConverter;
		}

		@Override
		public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
			converters.add(stringHttpMessageConverter());
			converters.add(mappingJackson2HttpMessageConverter());
		
		}
		//resource Mapping(URL Magic Mapping)
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry
				.addResourceHandler(env.getProperty("fileupload.resourceMapping"))
				.addResourceLocations("file:" + env.getProperty("fileupload.uploadLocation"));
		}
		
	}
