package com.example.demo.lvl.repository;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.example.demo.lvl.domain.Level;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class LevelRepositoryImpl extends QuerydslRepositorySupport 
									implements ILevelRepository{
	private final JPAQueryFactory qf;
	public LevelRepositoryImpl(JPAQueryFactory qf) {
		super(Level.class);
		this.qf = qf;
	}
}

