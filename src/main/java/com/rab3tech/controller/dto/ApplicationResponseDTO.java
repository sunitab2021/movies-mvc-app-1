package com.rab3tech.controller.dto;

public class ApplicationResponseDTO {
	
	private String code;
	private String message;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ApplicationResponseDTO [code=" + code + ", message=" + message + "]";
	}
	
	

}
