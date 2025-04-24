package de.ronasoft.springboot.vscode.repository;

import java.util.ArrayList;
import java.util.List;

import de.ronasoft.springboot.vscode.entity.Person;

public class PersonRepository {
    // create a list of persons
    private List<Person> persons = new ArrayList<>();

    // Create a new person
    public void addPerson(Person person) {
        persons.add(person);
    }

    // Read all persons
    public List<Person> getAllPersons() {
        return new ArrayList<>(persons);
    }

    // Read a person by ID
    public Person getPersonById(int id) {        
        return persons.stream()
                      .filter(person -> person.getId() == id)
                      .findFirst()
                      .orElse(null);
    }
    


    // Update a person
    public boolean updatePerson(int id, Person updatedPerson) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getId() == id) {
                persons.set(i, updatedPerson);
                return true;
            }
        }
        return false;
    }

    // Delete a person
    public boolean deletePerson(int id) {
        return persons.removeIf(person -> person.getId() == id);
    }
}