package de.ronasoft.testsprongboot.controller;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import de.ronasoft.springboot.vscode.entity.Person;
import de.ronasoft.springboot.vscode.repository.PersonRepository;

import java.util.List;

@Controller
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository personRepository;

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PersonController.class);

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personRepository.getAllPersons();
    }


    /**
     * Anzeige von allen Personen
     * @param model
     * @return
     */
    @GetMapping("/view")
    public String viewAllPersons(Model model) {
        List<Person> persons = personRepository.getAllPersons();
        LOGGER.info("viewAllPersons() called. Number Persons: {}", persons.size());
        model.addAttribute("persons",persons );
        return "personen";
    }

    @PostMapping("/submitSelected")
    public String handleSelected(@RequestParam("id") String id) {
        LOGGER.info("handleSelected() called. ID:[{}]", id);
        return "redirect:/success";
    }

       


    
}