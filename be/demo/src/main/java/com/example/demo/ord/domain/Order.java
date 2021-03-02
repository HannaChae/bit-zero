package com.example.demo.ord.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.brd.domain.Board;
import com.example.demo.cart.domain.Cart;
import com.example.demo.prd.domain.Product;
import com.example.demo.rcv.domain.Receiver;
import com.example.demo.usr.domain.User;

@Entity @Table(name="orders")
public class Order {
   @Id 
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name="ord_no") private int ordNo;
   @Column(name="ord_price") private String ordPrice;
   @Column(name="ord_amount") private int ordAmount;
   @Column(name="dvr_fee") private String dvrFee;
   @Column(name="ord_date") private String ordDate;
   @Column(name="ord_state") private String ordState;
   
   @ManyToOne
   @JoinColumn(name="usr_no")
   private User user;
   
   @ManyToOne
   @JoinColumn(name="prd_no")
   private Product product;
   
   @OneToMany(mappedBy="order")
   private List<Receiver> receiverList = new ArrayList<>();
   
   @OneToMany(mappedBy="order")
   private List<Board> boardList = new ArrayList<>();
   
   @OneToOne(mappedBy="order")
   private Cart cart;
   
}