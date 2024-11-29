package com.peanut.Equipment.config;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Resource
	private AuthenticationInterceptor authenticationInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/*
		 * 添加拦截器
		 * */
		registry.addInterceptor(authenticationInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns(
						"/v1/user/**",
						"/doc.html/**",
						"/v3/api-docs/**",
						"/webjars/**"
				);
	}
}
