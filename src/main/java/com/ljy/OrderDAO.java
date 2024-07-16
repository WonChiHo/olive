package com.ljy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://127.0.0.1:3306/olive";
	private final String DB_ID = "root";
	private final String DB_PWD = "1234";
	
	public List<OrderVO> selectList(){
		List<OrderVO> orderList = null;
		try {
			Class.forName(this.JDBC_DRIVER);
			this.conn = DriverManager.getConnection(this.DB_URL, this.DB_ID, this.DB_PWD);

			String query = "SELECT p.user_idx, p.item_idx, u.name, u.phone, p.moment, p.price, i.title, p.count " +
                    "FROM payment p " +
                    "JOIN user u ON p.user_idx = u.idx " +
                    "JOIN item i ON p.item_idx = i.idx";
			
			this.pstmt = this.conn.prepareStatement(query);
			
			this.rs = this.pstmt.executeQuery();
			
			orderList = new ArrayList<OrderVO>();
			
			while(this.rs.next()) {
				OrderVO ordervo = new OrderVO();
				//user_idx, item_idx, name, phone, 
				//moment, price, title
				ordervo.setUser_idx(this.rs.getInt("user_idx"));
				ordervo.setItem_idx(this.rs.getInt("item_idx"));
				ordervo.setName(this.rs.getString("name"));
				ordervo.setTitle(this.rs.getString("title"));
				ordervo.setPhone(this.rs.getString("phone"));
				ordervo.setMoment(this.rs.getDate("moment"));
				ordervo.setPrice(this.rs.getInt("price"));
				ordervo.setCount(this.rs.getInt("count"));
			
				orderList.add(ordervo);
				
			}
			
		} catch (Exception e) {
			System.out.println("OrderDAO selectList() ERR : " + e.getMessage());
		} finally {
			close(this.rs, this.pstmt, this.conn);
		}
		return orderList;
		
	}
	
	//한개
	public OrderVO selectOne(OrderVO ordervo) {
		try {
			Class.forName(this.JDBC_DRIVER);
			this.conn = DriverManager.getConnection(this.DB_URL, this.DB_ID, this.DB_PWD);
		
			String query = "select * from payment where item_idx=?";
			this.pstmt = this.conn.prepareStatement(query);
			
			this.pstmt.setInt(1, ordervo.getItem_idx());
			this.rs = this.pstmt.executeQuery();
			
			if(this.rs.next()) {
				//user_idx, item_idx, name, phone, 
				//moment, price 
				ordervo.setUser_idx(this.rs.getInt("user_idx"));
				ordervo.setItem_idx(this.rs.getInt("item_idx"));
				ordervo.setName(this.rs.getString("name"));
				ordervo.setPhone(this.rs.getString("phone"));
				ordervo.setMoment(this.rs.getDate("moment"));
				ordervo.setPrice(this.rs.getInt("price"));
			}
			
		} catch (Exception e) {
			System.out.println("selectOne() ERR : " + e.getMessage());
		} finally {
			close(this.rs, this.pstmt, this.conn);
		}
		return ordervo;
	}
	
	
	
	//close
	public void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
	}
	
}
