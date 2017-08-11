package org.lrf.old_driver;

import org.lrf.old_driver.interceptor.SetSelectedCityToResultMapInterceptor;
import org.lrf.old_driver.interceptor.SetUserToResultMapInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SetUserToResultMapInterceptor()).addPathPatterns("/*");
		registry.addInterceptor(new SetSelectedCityToResultMapInterceptor()).addPathPatterns("/*");
	}
}