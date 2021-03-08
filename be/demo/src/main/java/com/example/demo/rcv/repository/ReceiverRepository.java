package com.example.demo.rcv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.rcv.domain.Receiver;
import com.example.demo.rcv.repository.ReceiverCustomRepository;

interface ReceiverCustomRepository{
	
}
public interface ReceiverRepository extends JpaRepository<Receiver, Long>,
ReceiverCustomRepository{

}
