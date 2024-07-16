package com.ljy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://127.0.0.1:3306/olive";
	private final String DB_ID = "root";
	private final String DB_PWD = "1234";
	
	//전체 List
	public List<MemberVO> selectList(){
		List<MemberVO> memberList = null;
		
		try {
			
			Class.forName(this.JDBC_DRIVER);
			this.conn = DriverManager.getConnection(this.DB_URL, this.DB_ID, this.DB_PWD);

			String query = "select * from user";
			this.pstmt = this.conn.prepareStatement(query);
			
			this.rs = this.pstmt.executeQuery();
			
			memberList = new ArrayList<MemberVO>();
			
			while(this.rs.next()) {
				MemberVO membervo = new MemberVO();

				//idx, id, pw, name, email
				//phone, level, gender, address, coupon
				membervo.setIdx(this.rs.getInt("idx"));
				membervo.setId(this.rs.getString("id"));
				membervo.setPw(this.rs.getString("pw"));
				membervo.setName(this.rs.getString("name"));
				membervo.setEmail(this.rs.getString("email"));
				membervo.setPhone(this.rs.getString("phone"));
				membervo.setLevel(this.rs.getString("level"));
				membervo.setGender(this.rs.getString("gender"));
				membervo.setAddress(this.rs.getString("address"));
				
				memberList.add(membervo);
			}
			
		} catch (Exception e) {
			System.out.println("MemberDAO selectList() ERR : " + e.getMessage());
		} finally {
			close(this.rs, this.pstmt, this.conn);
		}
		return memberList;
	}
	
	//한개
	public MemberVO selectOne(MemberVO membervo) {
		try {
		
			Class.forName(this.JDBC_DRIVER);
			this.conn = DriverManager.getConnection(this.DB_URL, this.DB_ID, this.DB_PWD);
		
			String query = "select * from user where idx=?";
			
			this.pstmt = this.conn.prepareStatement(query);
			this.pstmt.setInt(1, membervo.getIdx());
			this.rs = this.pstmt.executeQuery();
			
			if(this.rs.next()) {

				//idx, id, pw, name, email, phone, 
				//level, gender, address, coupon
				membervo.setIdx(this.rs.getInt("idx"));
				membervo.setId(this.rs.getString("id"));
				membervo.setPw(this.rs.getString("pw"));
				membervo.setName(this.rs.getString("name"));
				membervo.setEmail(this.rs.getString("email"));
				membervo.setPhone(this.rs.getString("phone"));
				membervo.setLevel(this.rs.getString("level"));
				membervo.setGender(this.rs.getString("gender"));
				membervo.setAddress(this.rs.getString("address"));
			}
		} catch (Exception e) {
			System.out.println("selectOne() ERR : " + e.getMessage());
		} finally {
			close(this.rs, this.pstmt, this.conn);
		}
		return membervo;
	}
	
	//수정
	public void update(MemberVO membervo) {
		try {
			Class.forName(this.JDBC_DRIVER);
			this.conn = DriverManager.getConnection(this.DB_URL, this.DB_ID, this.DB_PWD);
			
			String query = "update user set name =?, level=? where idx=?";
		
			this.pstmt = this.conn.prepareStatement(query);
			System.out.println(membervo);
			this.pstmt.setString(1, membervo.getName());
			this.pstmt.setString(2, membervo.getLevel());
			this.pstmt.setInt(3, membervo.getIdx());
			int n = this.pstmt.executeUpdate();
			
			if(n >0) {
				System.out.println("=> UPDATE  SUCCESS");
			}
	
		} catch (Exception e) {
			System.out.println("update() ERR : " + e.getMessage());
		} finally {
			close(this.rs, this.pstmt, this.conn);
		}
	}
	//삭제
	public void delete(MemberVO membervo) {
		try {
			Class.forName(this.JDBC_DRIVER);
			this.conn = DriverManager.getConnection(this.DB_URL, this.DB_ID, this.DB_PWD);
			
			String query ="delete from user where idx=?";
			
			this.pstmt = this.conn.prepareStatement(query);
			this.pstmt.setInt(1, membervo.getIdx());
			
			int n = this.pstmt.executeUpdate();
			System.out.println(n);
			if(n>0) {
				System.out.println("=> DELETE SUCCESS");
			}
			
		} catch (Exception e) {
			System.out.println("delete() ERR : " + e.getLocalizedMessage());
		} finally {
			close(this.rs, this.pstmt, this.conn);
		}
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
