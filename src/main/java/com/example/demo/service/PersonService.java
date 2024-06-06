package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.PersonNameNullException;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService {
    
    @Autowired
    private PersonRepository personRepository;

    public Person save(Person person){
        if (person.getFirstName() == null || person.getUsername() == null ||person.getCpf() == null) {
            throw new PersonNameNullException();
        }
        return personRepository.save(person);
    }

    public List<Person> fildAll(){
        return personRepository.findAll();
    }

    public Person findById(Long id){
        return personRepository.findById(id).orElse(null);
    }

    public Optional<Person> findByUsername(String username){
        return personRepository.findByUsername(username);
    }

}
