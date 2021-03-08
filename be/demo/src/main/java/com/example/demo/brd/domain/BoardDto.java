package com.example.demo.brd.domain;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data @Component @Lazy
public class BoardDto {
	 private long brdNo;
	 private String  brdTitle;
	 private String brdContent;
	 private String brdWrtDate;
	 private String brdRank;
	 private String brdImg;
	 private String usrNickname;
	 private long brdKind;
	 private long count;
	 private String brdLike;
	 private String brdPwd;
}