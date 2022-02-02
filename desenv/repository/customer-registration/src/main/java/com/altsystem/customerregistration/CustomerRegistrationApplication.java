package com.altsystem.customerregistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//spring annotation
@SpringBootApplication
public class CustomerRegistrationApplication {

	
	private static final Logger LOGGER=LoggerFactory.getLogger(CustomerRegistrationApplication.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerRegistrationApplication.class, args);
		
		LOGGER.info("Versionamento rest API Spring Boot");
	
	}

}
