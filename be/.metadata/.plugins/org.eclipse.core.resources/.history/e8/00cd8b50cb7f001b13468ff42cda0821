package com.example.demo.rcv.repository;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.example.demo.rcv.domain.Receiver;
import com.example.demo.rcv.repository.IReceiverRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class ReceiverRepositoryImpl extends QuerydslRepositorySupport 
									implements IReceiverRepository{
	// private final JPAQueryFactory qf;
	public ReceiverRepositoryImpl() {
		super(Receiver.class);
		// this.qf = qf;
	}
}
