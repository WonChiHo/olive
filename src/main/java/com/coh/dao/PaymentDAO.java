package com.coh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.coh.query.Query;
import com.coh.vo.Payment;

public class PaymentDAO {
	private MySQLConnector dataSource;
	
	public PaymentDAO() {
		dataSource = new MySQLConnector();
	}
	
	public List<Payment> findByIdx(int idx) {
		Connection conn = dataSource.getConnector();
		List<Payment> payments = new LinkedList<>();
		Payment payment = null;
		try (PreparedStatement pstmt = conn.prepareStatement(Query.PAYMENT_BY_ID.getQuery())){
			pstmt.setInt(1, idx);
			ResultSet rs = pstmt.executeQuery();	
			while (rs.next()) {
				payment = new Payment();
				payment.setUser_idx(rs.getInt(1));
				payment.setItem_idx(rs.getInt(2));
				payment.setMoment(rs.getDate(3));
				payment.setPrice(rs.getInt(4));
				payments.add(payment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataSource.close();
		return payments;
	}
	
	public List<Payment> findBySixmonthById(int idx){
		Connection conn = dataSource.getConnector();
		List<Payment> payments = new LinkedList<>();
		Payment payment = null;
		try (PreparedStatement pstmt = conn.prepareStatement(Query.PAYMENT_SIX.getQuery())){
			pstmt.setInt(1, idx);
			ResultSet rs = pstmt.executeQuery();	
			while (rs.next()) {
				payment = new Payment();
				payment.setUser_idx(rs.getInt(1));
				payment.setItem_idx(rs.getInt(2));
				payment.setMoment(rs.getDate(3));
				payment.setPrice(rs.getInt(4));
				payments.add(payment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataSource.close();
		return payments;
	}

}
