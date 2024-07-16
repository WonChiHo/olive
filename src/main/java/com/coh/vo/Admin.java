package com.coh.vo;

public class Admin {
	private String id;
	private String pw;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", pw=" + pw + "]";
	}
	
	
}
