package com.hcl.bookmarkservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.hcl.bookmarkservice.config.JWTFilter;





@SpringBootApplication
public class BookMarkServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMarkServiceApplication.class, args);
	}
	
	/*@Bean
	public FilterRegistrationBean<?> filterRegistration(){
		
		FilterRegistrationBean registrationBean = new FilterRegistrationBean<>();
		
		registrationBean.addUrlPatterns("/api/v1/bookmarks/*");
		registrationBean.setFilter(new JWTFilter());
		return registrationBean;
		
	}*/
	
	
}
