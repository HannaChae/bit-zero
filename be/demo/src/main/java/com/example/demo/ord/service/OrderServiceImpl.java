package com.example.demo.ord.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.cmm.service.AbstractService;
import com.example.demo.ord.domain.Order;
import com.example.demo.ord.repository.OrderRepository;
import com.example.demo.ord.service.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl extends AbstractService<Order> 
								implements OrderService{
	private final OrderRepository repo;

	@Override public int save(Order t) {return (repo.save(t)!=null) ? 1 : 0 ;}
	@Override public int count() {return (int) repo.count();}
	@Override public Order getOne(int id) {return repo.getOne(id);}
	@Override public Optional<Order> findById(int id) {return repo.findById(id);}
	@Override public boolean existsById(int id) {return repo.existsById(id);}
	@Override public List<Order> findAll() {return repo.findAll();}
	@Override public int delete(Order t) {
		repo.delete(t); 
		return (getOne(t.getOrdNo())==null) ? 1 : 0;
	}
}
