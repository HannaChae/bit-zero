package com.example.demo.rpl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.rpl.domain.Reply;
import com.example.demo.rpl.repository.ReplyCustomRepository;

interface ReplyCustomRepository{
	
}

public interface ReplyRepository extends JpaRepository<Reply, Long>,
ReplyCustomRepository{

}