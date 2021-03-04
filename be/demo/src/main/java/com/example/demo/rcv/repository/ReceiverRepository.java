package com.example.demo.rcv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.rcv.domain.Receiver;
import com.example.demo.rcv.repository.IReceiverRepository;

interface IReceiverRepository{
	
}
public interface ReceiverRepository extends JpaRepository<Receiver, Integer>,
IReceiverRepository{

}
