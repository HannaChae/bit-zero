package com.example.demo.pay.repository;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.example.demo.pay.domain.Payment;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class PaymentRepositoryImpl extends QuerydslRepositorySupport 
									implements IOrderRepository{
	// private final JPAQueryFactory qf;
	public PaymentRepositoryImpl() {
		super(Payment.class);
		// this.qf = qf;
	}
}
