package com.example.demo.usr.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.usr.domain.User;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

	@Override
	public int insert(User m) {
		return 0;
	}

	@Override
	public User selectById(User m) {
		return null;
	}

	@Override
	public int update(User m) {
		return 0;
	}

	@Override
	public int delete(User m) {
		return 0;
	}

}
