package com.example.securitybasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.example.securitybasic") // Use when you want to run other controller outside of this main package
public class SecuritybasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuritybasicApplication.class, args);
	}

}
