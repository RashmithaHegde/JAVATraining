package com.app.SpringBootProject;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableAutoConfiguration
@SpringBootApplication
public class SpringBootProjectApplication {
	private static final Logger LOGGER = Logger.getLogger("SpringBootProjectApplication.class");
	public static void main(String[] args) {
		
	
		SpringApplication.run(SpringBootProjectApplication.class, args);
		
		LOGGER.info("started. . .!!!");
	}
}
