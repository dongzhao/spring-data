package com.dzhao.springmvc.h2db.model;

import com.dzhao.springmvc.h2db.model.generic.AbstractBaseDomain;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "my_order")
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Order extends AbstractBaseDomain {
    @Column(name="ORDER_DATE")
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name="CUST_ID", nullable=false)
    private Customer customer;

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
