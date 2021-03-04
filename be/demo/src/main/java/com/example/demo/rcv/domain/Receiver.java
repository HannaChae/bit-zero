package com.example.demo.rcv.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.ord.domain.Order;

import lombok.Getter;

@Entity @Table(name="Receivers") @Getter
public class Receiver {
      @Id 
      @GeneratedValue(strategy = GenerationType.AUTO)
      @Column(name="rcv_no") private int rcvNo;
      @Column(name="rcv_name") private String rcvName;
      @Column(name="rcv_phone") private String rcvPhone;
      @Column(name="rcv_addr") private String rcvAddr;
      
      @ManyToOne
      @JoinColumn(name="ord_no")
      private Order order;
}