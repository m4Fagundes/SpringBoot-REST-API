package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.PersonAlthenticated;
import com.example.demo.repository.PersonRepository;
@Service
public class PersonDetailService implements UserDetailsService {

  @Autowired
  private PersonRepository personRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return personRepository.findByUsername(username)
        .map(user -> new PersonAlthenticated(user))
        .orElseThrow(
            () -> new UsernameNotFoundException("User Not Found with username: " + username));
  }

}
