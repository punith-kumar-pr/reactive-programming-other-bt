package com.reactive.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class UserApplication {

	private static final Logger logger = LoggerFactory.getLogger(UserApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
		logger.info("Application started successfully");
	}

	@GetMapping
	public String hello() {
		logger.info("Hello world logged");
		return "Hello World reactive!!!";
	}
}
