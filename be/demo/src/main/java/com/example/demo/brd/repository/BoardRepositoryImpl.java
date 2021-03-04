package com.example.demo.brd.repository;


import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.example.demo.brd.domain.Board;
import com.example.demo.brd.domain.BoardDto;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class BoardRepositoryImpl extends QuerydslRepositorySupport 
									implements IBoardRepository{
	private final JPAQueryFactory qf;
	private final EntityManager em;
	
	public BoardRepositoryImpl(JPAQueryFactory qf, EntityManager em) {
		super(Board.class);
		this.qf = qf;
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Board> findByBrdTitle(String brdTitle) {
		return em.createNamedQuery("Board.findByBrdTitle")
				.setParameter("brdTitle", brdTitle)
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Board> findByWrittenDate(String writtenDate) {
		return em.createQuery("select b from Board b where b.written_date like :writtenDate")
				.setParameter("writtenDate", writtenDate)
				.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<BoardDto> findByUsrNo(int usrNo) {
		return em.createQuery("select "
				+ "b.brd_no brdNum "
				+ "b.brd_title brdTitle "
				+ "b.brd_content brdContent "
				+ "b.brdwritten_date brdwrittenDate "
				+ "b.brd_rank brdRank "
				+ "b.brd_img brdImg "
				+ "b.brd_kind brdKind "
				+ "b.brd_modDate brdModDate "
				+ "b.count count "
				+ "b.brd_like brdLike "
				+ "b.brd_pwd brdPwd "
				+ "b.usr_no usrNo "
				+ "b.usr_name usrName \n"
				+ "from Board b inner join User u on b.usr_no = u.usr_no \n"
				+ "where b.usr_no like : usrNo")
				.setParameter("usrNo", usrNo)
				.getResultList();
	}
}
