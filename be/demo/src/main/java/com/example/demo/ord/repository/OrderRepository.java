package com.example.demo.ord.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.ord.domain.Order;
import com.example.demo.ord.repository.IOrderRepository;

interface IOrderRepository{
	
}
public interface OrderRepository extends JpaRepository<Order, Integer>,
											IOrderRepository{

}