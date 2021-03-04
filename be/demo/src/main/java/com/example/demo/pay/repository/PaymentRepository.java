package com.example.demo.pay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pay.domain.Payment;
import com.example.demo.pay.repository.IOrderRepository;

interface IOrderRepository{
	
}
public interface PaymentRepository extends JpaRepository<Payment, Integer>,
											IOrderRepository{

}