package com.dzhao.springmvc.mongodb.restcontroller;

import com.dzhao.springmvc.mongodb.model.Person;
import com.dzhao.springmvc.mongodb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by dzhao on 9/05/2016.
 */
@RestController
@RequestMapping(value = "/mongodb/api/person")
public class PersonRestController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Person> create(@RequestBody Person person){
        Person result = new Person();
        result.setFirstName(person.getFirstName());
        result.setLastName(person.getLastName());
        result = personRepository.save(result);
        return new ResponseEntity<Person>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Person> update(@RequestBody Person person){
        Person result = personRepository.findOne(person.getId());
        if(!result.getFirstName().equalsIgnoreCase(person.getFirstName())){
            result.setFirstName(person.getFirstName());
        }
        if(!result.getLastName().equalsIgnoreCase(person.getLastName())){
            result.setLastName(person.getLastName());
        }
        result = personRepository.save(result);
        return new ResponseEntity<Person>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id){
        Person person = personRepository.findOne(id);
        personRepository.delete(person);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Person>> findAll(){
        List<Person> results = personRepository.findAll();
        return new ResponseEntity<List<Person>>(results, HttpStatus.OK);
    }

    @RequestMapping(value = "/firstname/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> findByFirstName(@PathVariable("name") String name){
        List<Person> results = personRepository.findByFirstName(name);
        return new ResponseEntity<List<Person>>(results, HttpStatus.OK);
    }

    @RequestMapping(value = "/lastname/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> findByLastName(@PathVariable("name") String name){
        List<Person> results = personRepository.findByLastName(name);
        return new ResponseEntity<List<Person>>(results, HttpStatus.OK);
    }
}
