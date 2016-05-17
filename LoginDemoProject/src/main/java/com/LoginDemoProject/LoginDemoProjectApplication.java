package com.LoginDemoProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.LoginDemoProject.repository")
@ComponentScan("com.LoginDemoProject")
public class LoginDemoProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(LoginDemoProjectApplication.class, args);
	}
}
