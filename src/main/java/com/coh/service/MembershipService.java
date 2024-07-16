package com.coh.service;

import java.util.List;

import com.coh.dao.CouponDAO;
import com.coh.dao.PaymentDAO;
import com.coh.dao.UserDAO;
import com.coh.query.Level;
import com.coh.vo.Coupon;
import com.coh.vo.Payment;
import com.coh.vo.User;

public class MembershipService {
	private UserDAO userDAO;
	private PaymentDAO paymentDAO;
	private CouponDAO couponDAO;
	
	public MembershipService() {
		this.userDAO = new UserDAO();
		this.paymentDAO = new PaymentDAO();
		this.couponDAO = new CouponDAO();
	}
	
	public List<Coupon> getCoupons(int userIdx){
		return couponDAO.findByUserId(userIdx);
	}
	
	public void updateUsersLevel() {
		List<User> users = userDAO.findAll();
		for (User user : users) {
			int userIdx = user.getIdx();
			Level level = getLevel(paymentDAO.findBySixmonthById(userIdx).stream()
					.mapToInt(Payment::getPrice)
					.sum());
			userDAO.updateUserLevel(userIdx, level.getLevel());
			Coupon coupon = getRegularCoupon(userIdx, level);
			publishCoupon(level, coupon);
		}
	}
	
	private void publishCoupon(Level level, Coupon coupon) {
		for (int i = 0; i < level.getCouponCount(); i++) {
			couponDAO.publishCoupon(coupon);
		}
	}
	
	private Coupon getRegularCoupon(int userIdx, Level level) {
		Coupon coupon = new Coupon();
		coupon.setUser_idx(userIdx);
		coupon.setName(level.getLevel() + " coupon");
		coupon.setDiscount(level.getDiscount());
		return coupon;
	}
	
	private Level getLevel(int totalSum) {
		Level level = Level.BABY;
		if (totalSum >= Level.GOLD.getTotalMoney())
			return Level.GOLD;
		if (totalSum >= Level.BLACK.getTotalMoney())
			return Level.BLACK;
		if (totalSum >= Level.GREEN.getTotalMoney())
			return Level.GREEN;
		if (totalSum >= Level.PINK.getTotalMoney())
			return Level.PINK;
		return level;
	}
	
	public void publishBirthdayCoupon() {
		List<User> users = userDAO.findByBirthdayALL();
		for (User user : users) {
			Coupon coupon = getBirthdayCoupon(user.getIdx());
			couponDAO.publishCoupon(coupon);
		}
	}
	
	private Coupon getBirthdayCoupon(int userIdx) {
		Coupon coupon = new Coupon();
		coupon.setUser_idx(userIdx);
		coupon.setDiscount(20);
		coupon.setName("birthday");
		return coupon;
	}
	

}
