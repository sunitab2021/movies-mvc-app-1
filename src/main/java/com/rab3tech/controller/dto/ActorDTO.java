package com.rab3tech.controller.dto;

import java.sql.Timestamp;

public class ActorDTO {
    private int mid;    
	private int aid;
	private String name;
	private String photo;
	private String role;
	private Timestamp createdate;
	

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Timestamp getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	@Override
	public String toString() {
		return "ActorDTO [aid=" + aid + ", name=" + name + ", photo=" + photo + ", role=" + role + ", createdate="
				+ createdate + "]";
	}

}
