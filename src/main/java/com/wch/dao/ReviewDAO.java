package com.wch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wch.dto.MySQLConnector;
import com.wch.dto.Review;

public class ReviewDAO {
	private Connection connect = null;
	private PreparedStatement pstmt = null;
	private MySQLConnector mysql = null;
	ResultSet rs = null;
	
	public ReviewDAO() {
		mysql = new MySQLConnector();
	}
	
	public ArrayList<Review> selectReview(int item_idx) {
		 ArrayList<Review> reviewList = new ArrayList<Review>();
		try {
			connect = mysql.connect();
			String query = "select * from review where item_idx=? order by idx desc";
			
			pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, item_idx);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Review review = new Review (
						rs.getInt("idx"),
						rs.getString("user_id"),
						rs.getInt("item_idx"),
						rs.getString("content"),
						rs.getString("image"),
						rs.getDate("moment"),
						rs.getInt("grade")
						);
						
				reviewList.add(review);

			}
			
		}catch(Exception e){
			System.out.println("selectQNA(int item_idx) Exception ERR : "+e.getMessage());
		}finally {
			mysql.close(connect, pstmt, rs);
		}
		
		return reviewList;
	}
	
	public void	insertReview(Review review, String category) {
		
		try {
			connect = mysql.connect();
			String  path = "";
			String query = "insert into review(user_id, item_idx, content, image, moment, grade) values (?, ?, ?, ?, now(), ?)";
			
			if(review.getImage()!="") {
				path = "/" +category+"/";
			}
			
			pstmt = connect.prepareStatement(query);
			pstmt.setString(1, review.getUser_id());
			pstmt.setInt(2, review.getItem_idx());
			pstmt.setString(3, review.getContent());
			pstmt.setString(4, path +review.getImage());
			pstmt.setInt(5, review.getGrade());
			
			int n=pstmt.executeUpdate();
			
			if(n < 1) {
				System.err.println("INSERT FAIL!!!!");
			}
			
		}catch (SQLException e) {
			System.err.println("insertReview(Review review) SQLException ERR : " + e.getMessage());
		}finally {
			mysql.close(connect, pstmt);
		}
	}
	
	public void deleteReview(int idx) {

		try {
			connect = mysql.connect();
			String query = "delete from review where idx=?";
			
			pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("deleteReview(int idx) SQLException ERR : " + e.getMessage());
		}finally {
			mysql.close(connect, pstmt);
		}
	}
	
	
}
