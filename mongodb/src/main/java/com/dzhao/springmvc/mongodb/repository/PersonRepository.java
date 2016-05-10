package com.dzhao.springmvc.mongodb.repository;

import com.dzhao.springmvc.mongodb.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by dzhao on 9/05/2016.
 */
public interface PersonRepository extends MongoRepository<Person, String>{

    List<Person> findByLastName(String lastName);
    List<Person> findByFirstName(String firstName);

}
