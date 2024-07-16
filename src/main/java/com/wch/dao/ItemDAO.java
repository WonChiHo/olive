package com.wch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wch.dto.Item;
import com.wch.dto.MySQLConnector;

public class ItemDAO {
	private Connection connect = null;
	private PreparedStatement pstmt = null;
	private MySQLConnector mysql = null;
	ResultSet rs = null;
	
	public ItemDAO() {
		mysql = new MySQLConnector();
	}
	
	public ArrayList<Item> selectItem() {
		 ArrayList<Item> itemList = new ArrayList<Item>();
		try {
			connect = mysql.connect();
			String query = "select * from item";
			
			pstmt = connect.prepareStatement(query);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Item item = new Item(rs.getInt("idx"),
									rs.getString("category"),
									rs.getString("title"),
									rs.getString("image"),
									rs.getInt("price"),
									rs.getString("detail"),
									rs.getInt("discount"),
									rs.getInt("stock_count"),
									rs.getInt("hit")
									);
				itemList.add(item);
			}
			
		}catch(Exception e){
			System.out.println("selectItem() Exception ERR : "+e.getMessage());
		}finally {
			mysql.close(connect, pstmt, rs);
		}
		
		return itemList;
	}
	
	public ArrayList<Item> selectSortHit() {
		 ArrayList<Item> itemList = new ArrayList<Item>();
		try {
			connect = mysql.connect();
			String query = "select * from item order by hit desc";
			
			pstmt = connect.prepareStatement(query);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Item item = new Item(rs.getInt("idx"),
									rs.getString("category"),
									rs.getString("title"),
									rs.getString("image"),
									rs.getInt("price"),
									rs.getString("detail"),
									rs.getInt("discount"),
									rs.getInt("stock_count"),
									rs.getInt("hit")
									);
				itemList.add(item);
			}
			
		}catch(Exception e){
			System.out.println("selectSortHit() Exception ERR : "+e.getMessage());
		}finally {
			mysql.close(connect, pstmt, rs);
		}
		
		return itemList;
	}
	
	public Item selectDetailItem(int idx){
		Item item = null;
		
		try {
			connect = mysql.connect();
			String query = "select * from item where idx = ?";
			
			pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, idx);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				item = new Item();
				item.setIdx(rs.getInt("idx"));
				item.setCategory(rs.getString("category"));
				item.setTitle(rs.getString("title"));
				item.setImage(rs.getString("image"));
				item.setPrice(rs.getInt("price"));
				item.setDetail(rs.getString("detail"));
				item.setDiscount(rs.getInt("discount"));
				item.setStock_count(rs.getInt("stock_count"));
				item.setHit(rs.getInt("hit"));
			}
			
		}catch(Exception e){
			System.out.println("selectDetailItem(int idx) Exception ERR : "+e.getMessage());
		}finally {
			mysql.close(connect, pstmt, rs);
		}
		return item;
	}
	
	public void updateHit(int idx, int hit) {
		
		try {
			connect = mysql.connect();
			String query= "update item set hit=?  where idx=?";
			pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, hit+1);
			pstmt.setInt(2, idx);
			
			int n =pstmt.executeUpdate();
			
			if(n < 1) {
				System.out.println("UPDATE FAIL !!!");
			}
			
		}catch (SQLException e) {
			System.err.println("updateHit(int idx, int hit) SQLException ERR : " + e.getMessage());
		}finally {
			mysql.close(connect, pstmt);
		}		
	}
}
