package com.rab3tech.controller.dto;

import java.util.Date;

public class MovieDTO {

	private int mid;
	private String name;
	private String year;
	private Date mdate;
	private String director;
	private String poster;
	private String story;
	
	

	public Date getMdate() {
		return mdate;
	}

	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	@Override
	public String toString() {
		return "MovieDTO [mid=" + mid + ", name=" + name + ", year=" + year + ", director=" + director + ", poster="
				+ poster + ", story=" + story + "]";
	}

}
