package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.model.PersonAlthenticated;
import com.example.demo.repository.PersonRepository;

public class PersonDetailService implements UserDetailsService{

    
    private final PersonRepository personRepository;

    public PersonDetailService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }


    @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return personRepository.findByUsername(username)
        .map(user -> new PersonAlthenticated(user))
        .orElseThrow(
            () -> new UsernameNotFoundException("User Not Found with username: " + username));
  }

}
