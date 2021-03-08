package com.example.demo.lvl.repository;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.example.demo.lvl.domain.Level;
@Repository
public class LevelRepositoryImpl extends QuerydslRepositorySupport 
									implements LevelCustomRepository{
	// private final JPAQueryFactory qf;
	public LevelRepositoryImpl() {
		super(Level.class);
		// this.qf = qf;
	}
}

