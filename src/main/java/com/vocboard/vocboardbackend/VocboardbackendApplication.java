package com.vocboard.vocboardbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class VocboardbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(VocboardbackendApplication.class, args);
	}

}
