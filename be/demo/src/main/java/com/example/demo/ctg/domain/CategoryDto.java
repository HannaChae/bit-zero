package com.example.demo.ctg.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;
@Data @Component @Lazy
public class CategoryDto {
	private int ctgNo;
	private String ctgName;
}