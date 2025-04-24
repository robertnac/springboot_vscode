package de.ronasoft.testsprongboot.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import de.ronasoft.springboot.vscode.entity.Person;
import de.ronasoft.springboot.vscode.repository.PersonRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/persons")
public class PersonController2 {

    private final PersonRepository personRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController2.class);
    

    public PersonController2(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/select-person")
    public String showPersonForm(Model model) {
        List<Person> persons = personRepository.getAllPersons();
        model.addAttribute("persons", persons);
        return "select_person";
    }

    @PostMapping("/select-person")
    public String handlePersonSelection(String personId, Model model) {
        LOGGER.debug("Selected personId: [{}]", personId);
        Person selectedPerson = personRepository.getPersonById(Integer.parseInt(personId));
        LOGGER.debug("Found person: [{}]", selectedPerson);
        // Use the personId as needed, e.g., fetch person details
        model.addAttribute("selectedPerson", selectedPerson);
        return "person_selected";
    }

     // initialize the repository with some data
    @Bean   
    CommandLineRunner init2() {
        return args -> {
            personRepository.addPerson(new Person(5, "John", "Doe", LocalDate.of(1990, 1, 1)));
            personRepository.addPerson(new Person(1, "Jane", "Smith", LocalDate.of(1992, 2, 2)));
            personRepository.addPerson(new Person(2, "Alice", "Johnson", LocalDate.of(1988, 5, 15)));
            personRepository.addPerson(new Person(3, "Bob", "Brown", LocalDate.of(1985, 7, 20)));
            personRepository.addPerson(new Person(4, "Jim", "Beam", LocalDate.of(1994, 3, 3)));
        };
    } 
}

