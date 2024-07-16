package com.wch.dto;

import java.sql.Date;

public class QNA {
	private int idx;
	private String user_id;
	private int item_idx;
	private String questionContent;
	private String answer;
	private Date moment;
	
	public QNA() {

	}
	
	public QNA(int idx, String user_id, int item_idx, String questionContent, String answer, Date moment) {
		this.idx = idx;
		this.user_id = user_id;
		this.item_idx = item_idx;
		this.questionContent = questionContent;
		this.answer = answer;
		this.moment = moment;
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

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	@Override
	public String toString() {
		return "QNA [idx=" + idx + ", user_id=" + user_id + ", item_idx=" + item_idx + ", questionContent="
				+ questionContent + ", answer=" + answer + ", moment=" + moment + "]";
	}

	
	
}
