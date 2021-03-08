package com.example.demo.sec.util;

import org.springframework.security.core.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public class AuthTokenProvider {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	@Value("${auth.jwtSecret}")
    private String jwtSecret;
	@Value("${auth.jwtExpirationMs}")
	private int jwtExpirationMs;
	
	public String generateToken(Authentication auth) {
		return null;
	}
	public Long getUserNoFromJWT(String token) {
		return null;
	}
	public boolean validateToken(String token) {
		return false;
	}

	
}
