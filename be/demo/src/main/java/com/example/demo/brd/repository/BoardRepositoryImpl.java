package com.example.demo.brd.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.brd.domain.Board;

@Repository
public class BoardRepositoryImpl implements BoardRepository{

	@Override
	public int insertWriter(Board b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Board> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Board b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Board b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Board selectById(String title) {
		// TODO Auto-generated method stub
		return null;
	}

}
