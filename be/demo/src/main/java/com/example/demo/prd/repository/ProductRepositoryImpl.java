package com.example.demo.prd.repository;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.example.demo.prd.domain.Product;



@Repository
public class ProductRepositoryImpl extends QuerydslRepositorySupport 
									implements ProductCustomRepository{
	// private final JPAQueryFactory qf;
	public ProductRepositoryImpl() {
		super(Product.class);
		// this.qf = qf;
	}
}
