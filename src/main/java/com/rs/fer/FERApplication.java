package com.rs.fer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value="classpath:${CONFIG_MODE}/application.properties")
public class FERApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(FERApplication.class, args);
	}
	
}
