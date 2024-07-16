package com.ljy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://127.0.0.1:3306/olive";
	private final String DB_ID = "root";
	private final String DB_PWD = "1234";
	
	//전체 List
	public List<ItemVO> selectList(ItemVO itemvo){
		List<ItemVO> itemList = null;
		int pageNum = Integer.parseInt(itemvo.getPageNum()); // "1" => 1
		int listCount = itemvo.getListCount();
		
		try {
			Class.forName(this.JDBC_DRIVER);
			this.conn = DriverManager.getConnection(this.DB_URL, this.DB_ID, this.DB_PWD);
			
			String query = "select * from item order by idx desc limit ?, ?";
			this.pstmt = this.conn.prepareStatement(query);
			
			this.pstmt.setInt(1, listCount * (pageNum - 1)); 
			this.pstmt.setInt(2, listCount);              
			
			
			
			this.rs = this.pstmt.executeQuery();
			
			itemList = new ArrayList<ItemVO>();
			
			while(this.rs.next()) {
				itemvo = new ItemVO();
				itemvo.setIdx(this.rs.getInt("idx"));
				itemvo.setCategory(this.rs.getString("category"));
				itemvo.setTitle(this.rs.getString("title"));
				itemvo.setImage(this.rs.getString("image"));
				itemvo.setPrice(this.rs.getInt("price"));
				itemvo.setDetail(this.rs.getString("detail"));
				itemvo.setDiscount(this.rs.getInt("discount"));
				itemvo.setStock_count(this.rs.getInt("stock_count"));
				itemvo.setHit(this.rs.getInt("hit"));
				
				itemList.add(itemvo);
			}
		} catch (Exception e) {
			System.out.println("ItemDAO selectList() ERR : " + e.getMessage());
			
		} finally {
			close(this.rs, this.pstmt, this.conn);
		}
		return itemList;
	}
	
	public List<ItemVO> selectAll(){
		List<ItemVO> itemList = null;

		try {
			Class.forName(this.JDBC_DRIVER);
			this.conn = DriverManager.getConnection(this.DB_URL, this.DB_ID, this.DB_PWD);
			
			String query = "select * from item";
			this.pstmt = this.conn.prepareStatement(query);
	
			this.rs = this.pstmt.executeQuery();
			
			itemList = new ArrayList<ItemVO>();
			
			while(this.rs.next()) {
				ItemVO itemvo = new ItemVO();
				itemvo.setIdx(this.rs.getInt("idx"));
				itemvo.setCategory(this.rs.getString("category"));
				itemvo.setTitle(this.rs.getString("title"));
				itemvo.setImage(this.rs.getString("image"));
				itemvo.setPrice(this.rs.getInt("price"));
				itemvo.setDetail(this.rs.getString("detail"));
				itemvo.setDiscount(this.rs.getInt("discount"));
				itemvo.setStock_count(this.rs.getInt("stock_count"));
				itemvo.setHit(this.rs.getInt("hit"));
				
				itemList.add(itemvo);
			}
		} catch (Exception e) {
			System.out.println("ItemDAO selectAll() ERR : " + e.getMessage());
			
		} finally {
			close(this.rs, this.pstmt, this.conn);
		}
		return itemList;
	}
	
	

	public int selectCount(ItemVO itemvo) {
		int totalCount = 0;
		try {
			Class.forName(this.JDBC_DRIVER);
			this.conn = DriverManager.getConnection(this.DB_URL, this.DB_ID, this.DB_PWD);
			
			String query = "select count(idx) as total from item";
			this.pstmt = this.conn.prepareStatement(query);
			
			this.rs = this.pstmt.executeQuery();
			
			if(this.rs.next()) {
				totalCount = this.rs.getInt("total");
			}
			
			
		} catch (Exception e) {
			System.out.println("selectCount() ERR : " + e.getMessage());
		} finally {
			close(this.rs, this.pstmt, this.conn);
		}
		return totalCount;
	}
	
	//한개
	public ItemVO selectOne(ItemVO itemvo) {
		try {
			Class.forName(this.JDBC_DRIVER);
			this.conn = DriverManager.getConnection(this.DB_URL, this.DB_ID, this.DB_PWD);
		
			String query = "select * from item where idx=?";
			this.pstmt = this.conn.prepareStatement(query);
			this.pstmt.setInt(1, itemvo.getIdx());
			this.rs = this.pstmt.executeQuery();
			
			if(this.rs.next()) {
				itemvo.setIdx(this.rs.getInt("idx"));
				itemvo.setCategory(this.rs.getString("category"));
				itemvo.setTitle(this.rs.getString("title"));
				itemvo.setImage(this.rs.getString("image"));
				itemvo.setPrice(this.rs.getInt("price"));
				itemvo.setDetail(this.rs.getString("detail"));
				itemvo.setDiscount(this.rs.getInt("discount"));
				itemvo.setStock_count(this.rs.getInt("stock_count"));
				itemvo.setHit(this.rs.getInt("hit"));
			}
			
		} catch (Exception e) {
			System.out.println("selectOne() ERR : " + e.getMessage());
		} finally {
			close(this.rs, this.pstmt, this.conn);
		}
		return itemvo;
	}
	
	//수정
	public void update(ItemVO itemvo) {
		try {
			Class.forName(this.JDBC_DRIVER);
			this.conn = DriverManager.getConnection(this.DB_URL, this.DB_ID, this.DB_PWD);
			//카테고리, 상품명, 상품 사진, 상품 가격, 상품 상세 설명
			String query = "update item set category =?, title=?, image =?, price=?, detail=? where idx=?";
			
			this.pstmt = this.conn.prepareStatement(query);
			
			String  path = "/" + itemvo.getCategory() +"/";
			this.pstmt.setString(1, itemvo.getCategory());
			this.pstmt.setString(2, itemvo.getTitle());
			this.pstmt.setString(3, path+itemvo.getImage());
			this.pstmt.setInt(4, itemvo.getPrice());
			this.pstmt.setString(5, path+itemvo.getDetail());
			this.pstmt.setInt(6, itemvo.getIdx());
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
	
	//입력
	public void insert(ItemVO itemvo) {
		try {
			Class.forName(this.JDBC_DRIVER);
			this.conn = DriverManager.getConnection(this.DB_URL, this.DB_ID, this.DB_PWD);
			//카테고리, 상품명, 상품 사진, 상품 가격, 상품 상세 설명

			String query = "insert into item (category, title, image, price, detail) values (?, ?, ?, ?, ?)";
			this.pstmt = this.conn.prepareStatement(query);
			
			String  path = "/" + itemvo.getCategory() +"/";
			this.pstmt.setString(1, itemvo.getCategory());
			this.pstmt.setString(2, itemvo.getTitle());
			this.pstmt.setString(3, path+itemvo.getImage());
			this.pstmt.setInt(4, itemvo.getPrice());
			this.pstmt.setString(5, path+itemvo.getDetail());
			
			this.pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("insert() ERR : " + e.getMessage());

		} finally {
			close(this.rs, this.pstmt, this.conn);
		}
	
	}
	
	//삭제
	public void delete(ItemVO itemvo) {
		try {
			Class.forName(this.JDBC_DRIVER);
			this.conn = DriverManager.getConnection(this.DB_URL, this.DB_ID, this.DB_PWD);
			
			String query = "delete from item where idx=?";
			
			this.pstmt = this.conn.prepareStatement(query);
			this.pstmt.setInt(1, itemvo.getIdx());
			int n = this.pstmt.executeUpdate();
			
			if(n>0) {
				System.out.println("=> DELETE SUCCESS");
			}
			
			
		} catch (Exception e) {
			System.out.println("delete() ERR : " + e.getMessage());
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
