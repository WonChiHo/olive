package com.coh.query;

public enum Level {
	GOLD("gold", 1000000, 13, 5),
	BLACK("black", 700000, 8, 4),
	GREEN("green", 400000, 5, 3),
	PINK("pink", 100000, 3, 2),
	BABY("baby", 0, 2, 1);
	
	private int totalMoney;
	private String level;
	private int discount;
	private int couponCount;
	
	private Level(String level, int totalMoney, int discount, int couponCount) {
		this.totalMoney = totalMoney;
		this.level = level;
		this.discount = discount;
		this.couponCount = couponCount;
	}
	
	public int getTotalMoney() {
		return totalMoney;
	}
	
	public String getLevel() {
		return level;
	}
	
	public int getDiscount() {
		return discount;
	}
	
	public int getCouponCount() {
		return couponCount;
	}
}
