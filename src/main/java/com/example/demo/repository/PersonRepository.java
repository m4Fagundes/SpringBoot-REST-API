package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

    @Query("SELECT e FROM Person e JOIN FETCH e.roles WHERE e.username= (:username)")
    Optional<Person> findByUsername(@Param ("username") String username);

}
