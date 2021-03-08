package com.example.demo.cart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.cmm.service.AbstractService;
import com.example.demo.cart.domain.Cart;
import com.example.demo.cart.repository.CartRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartServiceImpl extends AbstractService<Cart> 
								implements CartService{
	private final CartRepository repo;

	@Override public long save(Cart t) {return (repo.save(t)!=null) ? 1 : 0 ;}
	@Override public long count() {return (long) repo.count();}
	@Override public Cart getOne(long id) {return repo.getOne(id);}
	@Override public Optional<Cart> findById(long id) {return repo.findById(id);}
	@Override public boolean existsById(long id) {return repo.existsById(id);}
	@Override public List<Cart> findAll() {return repo.findAll();}
	@Override public long delete(Cart t) {
		repo.delete(t); 
		return (getOne(t.getCartNo())==null) ? 1 : 0;
	}
}