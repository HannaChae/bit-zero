package com.example.demo.cmm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"ctx", "mem", "cmm", "prdt", "board", "adm"})
public class HomeController {
	@Autowired HttpSession session;
	@Autowired HttpServletRequest request;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/")
	public String home(HttpSession session, HttpServletRequest request) {
		logger.info("ctx");
		String ctx = request.getContextPath();
		session.setAttribute("ctx", ctx);
		session.setAttribute("mem", ctx+"/resources/mem");
		session.setAttribute("cmm", ctx+"/resources/cmm");
		session.setAttribute("prdt", ctx + "/resources/prd");
    	session.setAttribute("board", ctx+"/resources/brd");
    	session.setAttribute("adm", ctx+"/resources/adm");
		return "index";
	}
		
	@GetMapping("/move/{dir}/{page}")
	public String move(@PathVariable String dir, @PathVariable String page) {
		logger.info("이동 : " + dir + "/" + page);
		return String.format("views:%s/%s", dir, page);
	}
}