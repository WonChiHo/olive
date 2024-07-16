package com.wch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wch.dto.MySQLConnector;
import com.wch.dto.QNA;

public class QNADAO {
	private Connection connect = null;
	private PreparedStatement pstmt = null;
	private MySQLConnector mysql = null;
	ResultSet rs = null;
	
	public QNADAO() {
		mysql = new MySQLConnector();
	}
	
	public ArrayList<QNA> selectQNA(int item_idx) {
		 ArrayList<QNA> qnaList = new ArrayList<QNA>();
		try {
			connect = mysql.connect();
			String query = "select * from qna where item_idx=? order by idx desc";
			
			pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, item_idx);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				QNA qna = new QNA(rs.getInt("idx"),
						rs.getString("user_id"),
						rs.getInt("item_idx"),
						rs.getString("questionContent"),
						rs.getString("answer"),
						rs.getDate("moment")
						);
						
				qnaList.add(qna);

			}
			
		}catch(Exception e){
			System.out.println("selectQNA() Exception ERR : "+e.getMessage());
		}finally {
			mysql.close(connect, pstmt, rs);
		}
		
		return qnaList;
	}
	
	public void	insertQNA(QNA qna) {
		
		try {
			connect = mysql.connect();
			
			String query = "insert into qna(user_id, item_idx, questionContent,answer, moment) values (?, ?, ?, ? ,now())";
			
			pstmt = connect.prepareStatement(query);
			pstmt.setString(1, qna.getUser_id());
			pstmt.setInt(2, qna.getItem_idx());
			pstmt.setString(3, qna.getQuestionContent());
			pstmt.setString(4, "");
			
			int n=pstmt.executeUpdate();
			
			if(n < 1) {
				System.err.println("INSERT FAIL!!!!");
			}
			
		}catch (SQLException e) {
			System.err.println("insertQNA(QNA qna) SQLException ERR : " + e.getMessage());
		}finally {
			mysql.close(connect, pstmt);
		}
		
	}
	
	
	public void deleteQNA(int idx) {

		try {
			connect = mysql.connect();
			String query = "delete from qna where idx=?";
			
			pstmt = connect.prepareStatement(query);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("deleteQNA(int idx) SQLException ERR : " + e.getMessage());
		}finally {
			mysql.close(connect, pstmt);
		}
	}
	
	public void updateQNA(int idx, String questionContent) {
		
		try {
			connect = mysql.connect();
			String query= "update qna set questionContent=?, moment=now() where idx=?";
			pstmt = connect.prepareStatement(query);
			pstmt.setString(1, questionContent);
			pstmt.setInt(2, idx);
			
			int n =pstmt.executeUpdate();
			
			if(n < 1) {
				System.out.println("UPDATE FAIL !!!");
			}
			
		}catch (SQLException e) {
			System.err.println("updateQNA(int idx, String questionContent) SQLException ERR : " + e.getMessage());
		}finally {
			mysql.close(connect, pstmt);
		}		
	}
	
}
