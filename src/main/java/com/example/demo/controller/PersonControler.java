package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;


@RestController
@RequestMapping(value = "/persons")
public class PersonControler {
    
    @Autowired
    private PersonService personService;

    @PostMapping(value = "/savePerson")
    public ResponseEntity<Person> registerPerson(@RequestBody Person person){
        
        personService.save(person);
        return ResponseEntity.ok().body(person);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id){
        
        Person person = personService.findById(id);
        return ResponseEntity.ok().body(person);
    } 
    
    @GetMapping(value = "/listAllPerson")
    public ResponseEntity<List<Person>> getAllPerson(){
        List<Person> persons = personService.fildAll();
        return ResponseEntity.ok().body(persons);
    }
}
