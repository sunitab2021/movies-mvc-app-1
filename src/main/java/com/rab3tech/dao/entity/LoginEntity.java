package com.rab3tech.dao.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="user_logins_tbl")
public class LoginEntity {
	
	private int lid;
	private String username;
	private String password;
	
	private Set<RolesEntity> roles;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles_tbl", joinColumns = { @JoinColumn(name = "lid") }, inverseJoinColumns = { @JoinColumn(name = "rid") })
	public Set<RolesEntity> getRoles() {
		return roles;
	}
	public void setRoles(Set<RolesEntity> roles) {
		this.roles = roles;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
