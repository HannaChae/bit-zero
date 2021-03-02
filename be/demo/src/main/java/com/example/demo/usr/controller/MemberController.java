package com.example.demo.usr.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.usr.domain.User;
import com.example.demo.usr.repository.MemberRepository;
import com.example.demo.usr.service.MemberServiceImpl;

import lombok.RequiredArgsConstructor;



@RestController @RequiredArgsConstructor
@RequestMapping(value = "/members", method = {RequestMethod.GET, RequestMethod.POST})
public class MemberController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	final MemberRepository memberRepository;
	final MemberServiceImpl memberService;
	
	@PostMapping("/join")
	public Map<?,?> join(@RequestBody User m) {
		var map = new HashMap<>();
        map.put("message", (memberService.join(m) == 1) ? "SUCCESS" : "FAILURE");
		return map;
	}
	
	@PostMapping("/login")
	public Map<?,?> login(@RequestBody User m){
		var map = new HashMap<>();
        User result = memberService.login(m);
        map.put("message", result != null ? "SUCCESS" : "FAILURE");
        map.put("sessionMember", result);
		logger.info("�α���: "+ m.toString());
        return map;
	}
	@PutMapping("/modify")
	public Map<?,?> modify(@RequestBody User m){
		var map = new HashMap<>();
		map.put("message", (memberService.modify(m) == 1? "SUCCESS" : "FAILURE"));
		logger.info("���� ����: "+ m.toString());
		return map;
	}
	
	@DeleteMapping("/withdrawal")
	public Map<?,?> withdrawal(@RequestBody User m){
		var map = new HashMap<>();
		logger.info("Ż��: "+ m.toString());
		map.put("message", (memberService.withdrawal(m) == 1? "SUCCESS" : "FAILURE"));
		return map;
	}
}