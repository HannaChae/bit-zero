package com.example.demo.prd.repository;

import java.util.List;

import com.example.demo.prd.domain.Product;

public interface ProductRepository {
	public int insert(Product prd);
	public List<Product> selectAll();
	public Product selectById(int prdId);
	public int update(Product prd);
	public int delete(Product prd);
}