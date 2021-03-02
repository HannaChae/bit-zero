package com.example.demo.prd.service;

import com.example.demo.prd.domain.Product;

public interface ProductService {
	public int add(Product prd);
	public int update(Product prd);
	public int delete(Product prd);
}