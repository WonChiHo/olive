package com.wch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wch.dto.MySQLConnector;
import com.wch.dto.Payment;

public class PaymentDAO {
	private Connection connect = null;
	private PreparedStatement pstmt = null;
	private MySQLConnector mysql = null;
	ResultSet rs = null;
	
	public PaymentDAO() {
		mysql = new MySQLConnector();
	}
	
	public void	insertPayment(Payment payment) {
		
		try {
			connect = mysql.connect();
			
			String query = "insert into payment(user_idx, item_idx, moment, price,count) values (?, ?, now(), ?, ?)";
			
			pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, payment.getUser_idx());
			pstmt.setInt(2, payment.getItem_idx());
			pstmt.setInt(3, payment.getPrice());
			pstmt.setInt(4, payment.getCount());
			
			int n=pstmt.executeUpdate();
			
			if(n < 1) {
				System.err.println("INSERT FAIL!!!!");
			}	
		}catch (SQLException e) {
			System.err.println("insertPayment(Payment payment) SQLException ERR : " + e.getMessage());
		}finally {
			mysql.close(connect, pstmt);
		}
		
	}
}
