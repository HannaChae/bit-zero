package com.example.demo.prd.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.prd.domain.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

	@Override
	public int insert(Product prd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Product> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product selectById(int prdId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Product prd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Product prd) {
		// TODO Auto-generated method stub
		return 0;
	}

}
