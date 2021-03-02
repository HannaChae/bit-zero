package com.example.demo.cart.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data @Component @Lazy
public class CartDto {
	private int cartNo;
	private int cartAmount;
}