package com.example.demo.ctg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.ctg.domain.Category;
import com.example.demo.ctg.repository.CategoryCustomRepository;

interface CategoryCustomRepository{
	
}
public interface CategoryRepository extends JpaRepository<Category, Long>,
													CategoryCustomRepository{

}
