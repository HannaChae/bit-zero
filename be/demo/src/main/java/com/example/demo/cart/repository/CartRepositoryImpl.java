package com.example.demo.cart.repository;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.example.demo.cart.domain.Cart;

@Repository
public class CartRepositoryImpl extends QuerydslRepositorySupport 
									implements CartCustomRepository{
	// private final JPAQueryFactory qf;
	public CartRepositoryImpl() {
		super(Cart.class);
		// this.qf = qf;
	}
}
