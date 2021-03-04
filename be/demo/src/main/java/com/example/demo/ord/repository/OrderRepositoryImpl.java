package com.example.demo.ord.repository;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.example.demo.ord.domain.Order;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class OrderRepositoryImpl extends QuerydslRepositorySupport 
									implements IOrderRepository{
	private final JPAQueryFactory qf;
	public OrderRepositoryImpl(JPAQueryFactory qf) {
		super(Order.class);
		this.qf = qf;
	}
}
