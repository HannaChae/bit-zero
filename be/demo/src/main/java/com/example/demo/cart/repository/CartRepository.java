package com.example.demo.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.cart.domain.Cart;
import com.example.demo.cart.repository.ICartRepository;

interface ICartRepository{
	
}
public interface CartRepository extends JpaRepository<Cart, Integer>,
											ICartRepository{

}