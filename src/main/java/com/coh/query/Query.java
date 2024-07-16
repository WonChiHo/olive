package com.coh.query;

public enum Query {
	USER_BY_ID("select * from user where id = ?"),
	ADMIN_BY_ID("select * from admin where id = ?"),
	JOIN("insert into user (id, pw, name, email, phone, gender, address, birthday) values (?,?,?,?,?,?,?,?)"),
	UPDATE_USER("update user set pw=?, name=?, email=?, phone=?, address=? where idx=?"),
	UPDATE_LEVEL("update user set level=? where idx = ?"),
	PAYMENT_BY_ID("select * from payment where user_idx = ?"),
	PAYMENT_SIX("SELECT * FROM payment WHERE user_idx = ? and moment >= DATE_SUB(NOW(), INTERVAL 6 MONTH)"),
	FIND_ALL("select * from user"),
	PUBLISH_COUPON("insert into coupon values (?,?,?,now())"),
	COUPON_BY_ID("select * from coupon where user_idx = ?"),
	FIND_BIRTHDAY("SELECT * FROM user WHERE MONTH(birthday) = MONTH(CURDATE()) AND DAY(birthday) = DAY(CURDATE())");
	
	private String query;
	
	private Query(String query) {
		this.query = query;
	}
	
	public String getQuery() {
		return query;
	}
}


/*
SELECT * FROM user WHERE MONTH(birthday) = MONTH(CURDATE()) AND DAY(birthday) = DAY(CURDATE());
*/