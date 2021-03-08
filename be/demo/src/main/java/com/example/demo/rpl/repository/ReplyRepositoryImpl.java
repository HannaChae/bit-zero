package com.example.demo.rpl.repository;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.example.demo.rpl.domain.Reply;

@Repository
public class ReplyRepositoryImpl extends QuerydslRepositorySupport 
									implements ReplyCustomRepository{
	// private final JPAQueryFactory qf;
	public ReplyRepositoryImpl() {
		super(Reply.class);
		// this.qf = qf;
	}

}
