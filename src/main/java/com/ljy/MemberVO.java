package com.ljy;

public class MemberVO {

	public MemberVO() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberVO(int idx, String id, String pw, String name, String email, String phone, String level, String gender, String address) {
		this.idx = idx;
		this.id = id;
		this.pw = pw;
		this.name= name;
		this.email = email;
		this.phone = phone;
		this.level = level;
		this.gender = gender;
		this.address = address;
	}
	
	private int idx;
	private String id;
	private String pw;
	private String name;
	private String email;
	private String phone;
	private String level;
	private String gender;
	private String address;

	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


}
