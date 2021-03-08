package com.example.demo.sec.domain;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorCode {
	GLOBAL(2), 
	NON_LOGIN(90), 
	EXPIRED_TOKEN(91),
	INVALID_TOKEN(92),
    AUTHENTICATION(93), 
    JWT_TOKEN_EXPIRED(94);
    private int errorCode;
    private ErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
    @JsonValue
    public int getErrorCode() {
        return errorCode;
    }
    @JsonValue
    public String getStatus() {
        return "관리자 권한입니다";
    }
    @JsonValue
    public String getMessage() {
        return "권한이 없습니다.";
    }
}