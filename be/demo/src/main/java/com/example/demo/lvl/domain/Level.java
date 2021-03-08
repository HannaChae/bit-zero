package com.example.demo.lvl.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;

@Entity
 @Getter
public class Level {

	@Id
	@Column(name = "level")
	private long level;

}