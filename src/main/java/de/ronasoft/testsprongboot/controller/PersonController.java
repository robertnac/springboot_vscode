package de.ronasoft.testsprongboot.controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.ronasoft.springboot.vscode.entity.Person;
import de.ronasoft.springboot.vscode.repository.PersonRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personRepository.getAllPersons();
    }

    // initialize the repository with some data
    @Bean   
    CommandLineRunner init() {
        return args -> {
            personRepository.addPerson(new Person(UUID.randomUUID(), "John", "Doe", LocalDate.of(1990, 1, 1)));
            personRepository.addPerson(new Person(UUID.randomUUID(), "Jane", "Doe", LocalDate.of(1992, 2, 2)));
            personRepository.addPerson(new Person(UUID.randomUUID(), "Jim", "Beam", LocalDate.of(1994, 3, 3)));
        };
    }    


    
}