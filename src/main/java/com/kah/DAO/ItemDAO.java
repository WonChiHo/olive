package com.kah.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.kah.Controller.ConnectSQLController;
import com.kah.VO.ItemVO;

public class ItemDAO {
	private Connection connect = null;
	private PreparedStatement pstmt = null;
	private ConnectSQLController mysql = null;
	ResultSet rs = null;
	
	public ItemDAO() {
		mysql = new ConnectSQLController();
	}
	
	public ArrayList<ItemVO> selectItem() {
		 ArrayList<ItemVO> itemList = new ArrayList<ItemVO>();
		try {
			connect = mysql.connectMYSQL();
			String query = "select * from item";
			
			pstmt = connect.prepareStatement(query);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				ItemVO item = new ItemVO(
						 rs.getInt("idx"),
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
				System.out.println(item);
			}
			
		}catch(Exception e){
			System.out.println("selectItem() Exception ERR : "+e.getMessage());
		}finally {
			mysql.close(rs, pstmt, connect);
		}
		
		return itemList;
	}
	
	public ArrayList<ItemVO> selectSortHit() {
		 ArrayList<ItemVO> itemList = new ArrayList<ItemVO>();
		try {
			connect = mysql.connectMYSQL();
			String query = "select * from item order by hit desc";
			
			pstmt = connect.prepareStatement(query);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				ItemVO item = new ItemVO(rs.getInt("idx"),
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
				System.out.println(item);
			}
			
		}catch(Exception e){
			System.out.println("selectSortHit() Exception ERR : "+e.getMessage());
		}finally {
			mysql.close(rs, pstmt, connect);
		}
		
		return itemList;
	}
	
	public ItemVO selectDetailItem(int idx){
		ItemVO item = null;

		try {
			connect = mysql.connectMYSQL();
			String query = "select * from item where idx = ?";
			
			pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, idx);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				item = new ItemVO();
				item.setIdx(rs.getInt("idx"));
				item.setCategory(rs.getString("category"));
				item.setTitle(rs.getString("title"));
				item.setImage(rs.getString("image"));
				item.setPrice(rs.getInt("price"));
				item.setDetail(rs.getString("detail"));
				item.setDiscount(rs.getInt("discount"));
				item.setStock_count(rs.getInt("stock_count"));
				item.setHit(rs.getInt("hit"));
				System.out.println(item);
			}
			
		}catch(Exception e){
			System.out.println("selectDetailItem(int idx) Exception ERR : "+e.getMessage());
		}finally {
			mysql.close(rs, pstmt, connect);
			
		}
		return item;
	}
}
