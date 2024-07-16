package com.coh.vo;

import java.sql.Date;

public class Coupon {
	private int user_idx;
	private String name;
	private int discount;
	private Date moment;
	
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public Date getMoment() {
		return moment;
	}
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	@Override
	public String toString() {
		return "Coupon [user_idx=" + user_idx + ", name=" + name + ", discount=" + discount + ", moment=" + moment
				+ "]";
	}
	
}
