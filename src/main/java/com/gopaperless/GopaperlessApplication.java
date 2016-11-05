package com.gopaperless;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableMongoRepositories("com.gopaperless.repository")
public class GopaperlessApplication {

	public static void main(String[] args) {
		SpringApplication.run(GopaperlessApplication.class, args);
	}
}
