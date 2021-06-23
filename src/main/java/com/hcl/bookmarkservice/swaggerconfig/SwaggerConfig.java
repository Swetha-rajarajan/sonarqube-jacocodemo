package com.hcl.bookmarkservice.swaggerconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;





@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	/*Swagger is mainly used to provide documentation 
	for our api's which is nothing but an framework for defining and creating api's
	*/
	
    @Bean
    public Docket postsApi(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().paths(postPaths()).build();	}

    private Predicate<String> postPaths() {
        // TODO Auto-generated method stub
        return (regex("/api/v1/bookmarks.*"));	}

    private ApiInfo apiInfo() {
        // TODO Auto-generated method stub
        return new ApiInfoBuilder().title("HCL API").
                description("Swagger Implementation").
                termsOfServiceUrl("http://hcl.in").
                contact("swetharajarajan@gmail.com").license
                ("HCL License").licenseUrl("swetha@gmail.com").
                version("1.0").build();
    }}

	
	


