package com.lombok.lombok_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LombokProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(LombokProjectApplication.class, args);
	}

}
