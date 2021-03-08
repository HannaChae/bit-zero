package com.example.demo.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.cart.domain.Cart;
import com.example.demo.cart.repository.CartCustomRepository;

interface CartCustomRepository{
	
}
public interface CartRepository extends JpaRepository<Cart, Long>,
												CartCustomRepository{

}