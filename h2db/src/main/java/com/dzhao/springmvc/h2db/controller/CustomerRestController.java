package com.dzhao.springmvc.h2db.controller;

import com.dzhao.springmvc.h2db.model.Customer;
import com.dzhao.springmvc.h2db.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by dzhao on 10/05/2016.
 */
@RestController
@RequestMapping(value = "/h2/api/customer")
public class CustomerRestController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Customer> create(@RequestBody Customer customer){
        Customer result = new Customer();
        result.setFirstName(customer.getFirstName());
        result.setLastName(customer.getLastName());
        result.setGender(customer.getGender());
        result = customerRepository.save(result);
        return new ResponseEntity<Customer>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Customer> update(@RequestBody Customer customer){
        Customer result = customerRepository.findOne(customer.getId());
        if(!result.getFirstName().equalsIgnoreCase(customer.getFirstName())){
            result.setFirstName(customer.getFirstName());
        }
        if(!result.getLastName().equalsIgnoreCase(customer.getLastName())){
            result.setLastName(customer.getLastName());
        }
        if(!result.getGender().equals(customer.getGender())){
            result.setGender(customer.getGender());
        }
        result = customerRepository.save(result);
        return new ResponseEntity<Customer>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id){
        Customer customer = customerRepository.findOne(id);
        customerRepository.delete(customer);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> findAll(){
        List<Customer> results = customerRepository.findAll();
        return new ResponseEntity<List<Customer>>(results, HttpStatus.OK);
    }
}
