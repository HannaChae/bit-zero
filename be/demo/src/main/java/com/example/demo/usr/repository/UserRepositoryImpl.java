package com.example.demo.usr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.example.demo.usr.domain.QUser;
import com.example.demo.usr.domain.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
@Repository
public class UserRepositoryImpl extends QuerydslRepositorySupport 
									implements UserCustomRepository{
	private final JPAQueryFactory qf;
	public UserRepositoryImpl(JPAQueryFactory qf) {
		super(User.class);
		this.qf = qf;
	}
	public List<User> test(){
		QUser user = QUser.user;
		return qf.selectFrom(user).fetch();
	}
}
