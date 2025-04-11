package de.ronasoft.testsprongboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.context.annotation.Bean;
import de.ronasoft.springboot.vscode.repository.PersonRepository;

@SpringBootApplication
@EnableScheduling // Enable scheduling in the application
public class TestsprongbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestsprongbootApplication.class, args);
	}

	@Bean
	public PersonRepository personRepository() {
		return new PersonRepository();
	}
}
