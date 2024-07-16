package com.coh.vo;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class User implements HttpSessionListener {
	private static int activeSession;
	private int idx;
	private String id;
	private String pw;
	private String name;
	private String email;
	private String phone;
	private String level;
	private String gender;
	private String address;
	private String birthday;
	
	public User() {
	}

	public String getBirthday() {
		return birthday;
	}

	public static int getActiveSession() {
		return activeSession;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

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

	@Override
	public String toString() {
		return "User [idx=" + idx + ", id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email + ", phone="
				+ phone + ", level=" + level + ", gender=" + gender + ", address=" + address + ", birthday=" + birthday
				+ "]";
	}
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		++activeSession;
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		activeSession -= 1;
	}
}
