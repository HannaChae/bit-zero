package com.example.demo.brd.domain;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data @Component @Lazy
public class BoardDto {
	 private int brdNo;
	 private String  brdTitle;
	 private String brdContent;
	 private String brdwrittenDate;
	 private String brdRank;
	 private String brdImg;
	 private int brdKind;
	 private String brdModDate;
	 private int count;
	 private int brdLike;
	 private int brdPwd;
	 private int usrNo;
	 private String usrName;
	 private String usrEmail;
}