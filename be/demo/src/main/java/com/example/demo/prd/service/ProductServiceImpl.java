package com.example.demo.prd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.cmm.service.AbstractService;
import com.example.demo.prd.domain.Product;
import com.example.demo.prd.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends AbstractService<Product> 
								implements ProductService{
	private final ProductRepository repo;

	@Override public long save(Product t) {return (repo.save(t)!=null) ? 1 : 0 ;}
	@Override public long count() {return (long) repo.count();}
	@Override public Product getOne(long id) {return repo.getOne(id);}
	@Override public Optional<Product> findById(long id) {return repo.findById(id);}
	@Override public boolean existsById(long id) {return repo.existsById(id);}
	@Override public List<Product> findAll() {return repo.findAll();}
	@Override public long delete(Product t) {
		repo.delete(t); 
		return (getOne(t.getPrdNo())==null) ? 1 : 0;
	}
}
