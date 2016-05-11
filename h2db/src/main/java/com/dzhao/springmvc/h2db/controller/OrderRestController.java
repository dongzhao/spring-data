package com.dzhao.springmvc.h2db.controller;

import com.dzhao.springmvc.h2db.model.Customer;
import com.dzhao.springmvc.h2db.model.Order;
import com.dzhao.springmvc.h2db.repository.CustomerRepository;
import com.dzhao.springmvc.h2db.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by dzhao on 10/05/2016.
 */
@RestController
@RequestMapping(value = "/h2/api/order")
public class OrderRestController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Order> create(@RequestBody Order order){
        Order result = new Order();
        Customer customer = customerRepository.findOne(order.getCustomer().getId());
        result.setOrderDate(order.getOrderDate());
        result.setProduct(order.getProduct());
        result.setQuantity(order.getQuantity());
        result.setCustomer(customer);
        result = orderRepository.save(result);
        return new ResponseEntity<Order>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id){
        Order order = orderRepository.findOne(id);
        orderRepository.delete(order);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Order> findById(@PathVariable("id") String id){
        Order results = orderRepository.findOne(id);
        return new ResponseEntity<Order>(results, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Order>> findAll(){
        List<Order> results = orderRepository.findAll();
        return new ResponseEntity<List<Order>>(results, HttpStatus.OK);
    }
}
