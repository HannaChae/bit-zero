package com.example.demo.ctg.repository;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.example.demo.ctg.domain.Category;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class CategoryRepositoryImpl extends QuerydslRepositorySupport 
									implements ICategoryRepository{
	private final JPAQueryFactory qf;
	public CategoryRepositoryImpl(JPAQueryFactory qf) {
		super(Category.class);
		this.qf = qf;
	}
}
