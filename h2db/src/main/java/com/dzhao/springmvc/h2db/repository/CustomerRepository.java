package com.dzhao.springmvc.h2db.repository;

import com.dzhao.springmvc.h2db.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dzhao on 10/05/2016.
 */
public interface CustomerRepository extends JpaRepository<Customer, String>{
}
