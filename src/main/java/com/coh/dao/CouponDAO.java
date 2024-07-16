package com.coh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.coh.query.Query;
import com.coh.vo.Coupon;

public class CouponDAO {
	MySQLConnector dataSource;
	
	public CouponDAO() {
		dataSource = new MySQLConnector();
	}
	
	public void publishCoupon(Coupon coupon) {
		Connection conn = dataSource.getConnector();
		try (PreparedStatement pstmt = conn.prepareStatement(Query.PUBLISH_COUPON.getQuery())){
			pstmt.setInt(1, coupon.getUser_idx());
			pstmt.setString(2, coupon.getName());
			pstmt.setInt(3, coupon.getDiscount());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataSource.close();
	}
	
	public List<Coupon> findByUserId(int idx){
		Connection conn = dataSource.getConnector();
		List<Coupon> coupons = new LinkedList<>();
		try (PreparedStatement pstmt = conn.prepareStatement(Query.COUPON_BY_ID.getQuery())){
			pstmt.setInt(1, idx);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Coupon coupon = new Coupon();
				coupon.setDiscount(rs.getInt("discount"));
				coupon.setMoment(rs.getDate("moment"));
				coupon.setName(rs.getString("name"));
				coupon.setUser_idx(rs.getInt("user_idx"));
				coupons.add(coupon);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataSource.close();
		return coupons;
	}

}
