package com.example.demo.prd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.prd.domain.Product;

interface ProductCustomRepository{
	
}
public interface ProductRepository extends JpaRepository<Product, Long>,
ProductCustomRepository{

}