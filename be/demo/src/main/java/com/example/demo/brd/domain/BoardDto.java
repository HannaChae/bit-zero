package com.example.demo.brd.domain;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data @Component @Lazy
public class BoardDto {
	 private int brdNo;
	 private String  brdTitle;
	 private String brdContent;
	 private String brdWrtDate;
	 private String brdRank;
	 private String brdImg;
	 private String usrNickname;
	 private int brdKind;
	 private int count;
	 private String brdLike;
	 private String brdPwd;
}