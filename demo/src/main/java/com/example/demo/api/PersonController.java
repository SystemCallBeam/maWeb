package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonSevice personSevice;

    @Autowired
    public PersonController(PersonSevice personSevice) {
        this.personSevice = personSevice;
    }

    @PatchMapping
    public void addPerson(@RequestBody Person person) {
        personSevice.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPerson() {
        return personSevice.getAllPeople();
    }

    public Person getPersonById(UUID id) {
        return personSevice.getPersonById(id).orElse(null);
    }
}
