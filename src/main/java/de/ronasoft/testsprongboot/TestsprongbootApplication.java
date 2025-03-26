package de.ronasoft.testsprongboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // Enable scheduling in the application
public class TestsprongbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestsprongbootApplication.class, args);
	}

}
