package com.ljy;

import java.sql.Date;

public class OrderVO {

	//user_idx, item_idx, name, phone, moment, price 
	private int user_idx;
	private int item_idx;
	private String name;
	private String phone;
	private String title;
	private Date moment;
	private int price;
	private int count;
	public OrderVO() {
		// TODO Auto-generated constructor stub
	}
	
	public OrderVO(int user_idx, int item_idx, String name, String phone, Date moment, int price, int count) {
		this.user_idx = user_idx;
		this.item_idx = item_idx;
		this.name = name;
		this.phone = phone;
		this.moment = moment;
		this.price = price;
		this.count = count;
	}
	
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	public int getItem_idx() {
		return item_idx;
	}
	public void setItem_idx(int item_idx) {
		this.item_idx = item_idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getMoment() {
		return moment;
	}
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "OrderVO [user_idx=" + user_idx + ", item_idx=" + item_idx + ", name=" + name + ", phone=" + phone
				+ ", title=" + title + ", moment=" + moment + ", price=" + price + ", count=" + count + "]";
	}

}
