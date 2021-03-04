package com.example.demo.cart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.ord.domain.Order;

@Entity @Table(name="carts")
public class Cart {
   @Id 
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name="cart_no") private int cartNo;
   @Column(name="cart_amount") private int cartAmount;
   
   @OneToOne
   @JoinColumn(name = "ord_no")
   private Order order;
}