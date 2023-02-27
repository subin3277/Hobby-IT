package com.a505.hobbyit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HobbyitApplication {
	public static void main(String[] args) {
		SpringApplication.run(HobbyitApplication.class, args);
	}

}
