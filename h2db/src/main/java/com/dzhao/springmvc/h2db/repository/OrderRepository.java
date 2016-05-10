package com.dzhao.springmvc.h2db.repository;

import com.dzhao.springmvc.h2db.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dzhao on 10/05/2016.
 */
public interface OrderRepository extends JpaRepository<Order, String>{
}
