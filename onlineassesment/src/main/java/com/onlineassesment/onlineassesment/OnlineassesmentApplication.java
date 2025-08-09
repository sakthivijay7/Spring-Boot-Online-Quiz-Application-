package com.onlineassesment.onlineassesment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.onlineassesment")
@EnableJpaRepositories("com.onlineassesment.onlineassesment.Repository")

public class OnlineassesmentApplication {
	public static void main(String[] args) {
		SpringApplication.run(OnlineassesmentApplication.class, args);
	}
}
