package com.galvanize.tmo.paspringstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.galvanize.tmo.paspringstarter.dao")
public class PaSpringStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaSpringStarterApplication.class, args);
	}

}
