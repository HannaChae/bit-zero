package com.example.demo.prd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cmm.controller.HomeController;
import com.example.demo.prd.domain.Product;
import com.example.demo.prd.repository.ProductRepository;
import com.example.demo.prd.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
	final ProductRepository productRepository;
	final ProductService productService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@PostMapping("")
	public Map<?,?> add(@RequestBody Product prd) {
		var map = new HashMap<>();
		logger.info("�߰��� ��ǰ: " + prd.toString());
		map.put("message", productService.add(prd) == 1? "SUCCESS" : "FAILURE");
		return map;
	}
	
	@GetMapping("/list")
	public List<Product> list() {
		return productRepository.selectAll();
	}
	
	@GetMapping("/{prdId}")
	public Product detail(@PathVariable int prdId) {
		logger.info("��ȸ�� ��ǰ��ȣ: " + prdId);
		return productRepository.selectById(prdId);
	}
	
	@PutMapping("")
	public Map<?,?> update(@RequestBody Product prd) {
		var map = new HashMap<>();
		map.put("message", productService.update(prd) == 1? "SUCCESS" : "FAILURE");
		return map;
	}
	
	@DeleteMapping("")
	public Map<?,?> delete(@RequestBody Product prd) {
		var map = new HashMap<>();
		map.put("message", productService.delete(prd) == 1? "SUCCESS" : "FAILURE");
		return map;
	}
}