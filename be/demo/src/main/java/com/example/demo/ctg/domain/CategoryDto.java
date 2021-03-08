package com.example.demo.ctg.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;
@Data @Component @Lazy
public class CategoryDto {
	private long ctgNo;
	private String ctgName;
}