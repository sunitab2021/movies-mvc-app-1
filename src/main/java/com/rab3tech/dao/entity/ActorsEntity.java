package com.rab3tech.dao.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="actors_tbl")
public class ActorsEntity {
	
	private int aid;
	private String name;
	private String photo;
	private String role;
	private Timestamp createdate;
	
	private MovieEntity movie;
	
	 @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "fmid")
	public MovieEntity getMovie() {
		return movie;
	}
	 
	public void setMovie(MovieEntity movie) {
		this.movie = movie;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	

}
