package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// Configuration
// enable swagger 
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private static final Contact DEFAULT_CONTACT = new Contact("Manisha","http://www.","mani@gmail.com");
	private static final ApiInfo DEFAULT_API_INFO = //new ApiInfo(title, description, version, termsOfServiceUrl, contact, license, licenseUrl, vendorExtensions)
			new ApiInfo("Awesome API document", 
			"Awesome API description","1.0",
			"urn:tos",
			DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/license",new ArrayList());
	private static final Set<String> DEFAULT_PRODUCE_CONSUME = new HashSet<String>(Arrays.asList("application/json","application/xml"));

	// bean -docket
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
			.apiInfo(DEFAULT_API_INFO)
			.produces(DEFAULT_PRODUCE_CONSUME)
			.consumes(DEFAULT_PRODUCE_CONSUME);
			
	}
	//swagger 2
	//all paths
	// all apis

}
