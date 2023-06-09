package com.example.securitybasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
//@EnableJpaRepositories("com.example.securitybasic.repository")
//@EntityScan("com.example.securitybasic.model")
//@EnableWebSecurity
//@ComponentScan("com.example.securitybasic") // Use when you want to run other controller outside of this main package
public class SecuritybasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuritybasicApplication.class, args);
	}

}
