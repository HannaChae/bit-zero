package com.example.demo.rpl.repository;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.example.demo.rpl.domain.Reply;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class ReplyRepositoryImpl extends QuerydslRepositorySupport 
									implements IReplyRepository{
	private final JPAQueryFactory qf;
	public ReplyRepositoryImpl(JPAQueryFactory qf) {
		super(Reply.class);
		this.qf = qf;
	}

}
