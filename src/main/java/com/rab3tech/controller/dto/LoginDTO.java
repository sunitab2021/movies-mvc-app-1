package com.rab3tech.controller.dto;

import java.util.Set;

public class LoginDTO {
	
	private int lid;
	private String username;
	private String password;
	
	private Set<RolesDTO> roles;
	
	public Set<RolesDTO> getRoles() {
		return roles;
	}
	public void setRoles(Set<RolesDTO> roles) {
		this.roles = roles;
	}
	
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
