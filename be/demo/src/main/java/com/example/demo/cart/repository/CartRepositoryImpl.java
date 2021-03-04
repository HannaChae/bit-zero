package com.example.demo.cart.repository;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.example.demo.cart.domain.Cart;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class CartRepositoryImpl extends QuerydslRepositorySupport 
									implements ICartRepository{
	private final JPAQueryFactory qf;
	public CartRepositoryImpl(JPAQueryFactory qf) {
		super(Cart.class);
		this.qf = qf;
	}
}
