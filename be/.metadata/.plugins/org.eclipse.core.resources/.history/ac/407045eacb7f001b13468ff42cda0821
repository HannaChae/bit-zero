package com.example.demo.usr.repository;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.example.demo.usr.domain.User;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class UserRepositoryImpl extends QuerydslRepositorySupport 
									implements IUserRepository{
	// private final JPAQueryFactory qf;
	public UserRepositoryImpl() {
		super(User.class);
		// this.qf = qf;
	}

}
