package com.example.demo.lvl.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


import lombok.Data;

@Component @Data @Lazy
public class LevelDto {
	private long level;
}