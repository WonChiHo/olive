package com.wch.dto;

import java.sql.Date;

public class Review {
	private int idx;
	private String user_id;
	private int item_idx;
	private String content;
	private String image;
	private Date moment;
	private int grade;
	
	public Review() {
	}
	
	public Review(int idx, String user_id, int item_idx, String content, String image, Date moment, int grade) {
		this.idx = idx;
		this.user_id = user_id;
		this.item_idx = item_idx;
		this.content = content;
		this.image = image;
		this.moment = moment;
		this.grade = grade;
	}
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getItem_idx() {
		return item_idx;
	}

	public void setItem_idx(int item_idx) {
		this.item_idx = item_idx;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Review [idx=" + idx + ", user_id=" + user_id + ", item_idx=" + item_idx + ", content=" + content
				+ ", image=" + image + ", moment=" + moment + ", grade=" + grade + "]";
	}

}
