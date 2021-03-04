package com.example.demo.brd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.brd.domain.Board;
import com.example.demo.brd.domain.BoardDto;
interface IBoardRepository{
	public List<Board> findByBrdTitle(String brdTitle);
	public List<Board> findByBrdWrtDate(String brdWrtDate);
	public List<BoardDto> findByUsrNo(int usrNo);
}
public interface BoardRepository extends JpaRepository<Board, Integer>,
									IBoardRepository{
}