package com.ljy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://127.0.0.1:3306/olive";
	private final String DB_ID = "root";
	private final String DB_PWD = "1234";

	//전체 List
	public List<BoardVO> selectList(){
		List<BoardVO> boardList = null;
		try {
			
			Class.forName(this.JDBC_DRIVER);
			this.conn = DriverManager.getConnection(this.DB_URL, this.DB_ID, this.DB_PWD);

			String query = "select q.idx, q.user_id, i.category, q.questionContent, q.moment, q.item_idx, q.answer from qna q join item i on q.item_idx = i.idx";
			this.pstmt = this.conn.prepareStatement(query);
			
			this.rs = this.pstmt.executeQuery();
			
			boardList = new ArrayList<BoardVO>();
			
			while(this.rs.next()) {
				BoardVO boardvo = new BoardVO();

				//idx, user_id, category, item_idx, 
				//questionTitle, questionContent, answer, moment
				boardvo.setIdx(this.rs.getInt("idx"));
				boardvo.setUser_id(this.rs.getString("user_id"));
				boardvo.setCategory(this.rs.getString("category"));
				boardvo.setItem_idx(this.rs.getInt("item_idx"));
				boardvo.setQuestionContent(this.rs.getString("questionContent"));
				boardvo.setAnswer(this.rs.getString("answer"));
				boardvo.setMoment(this.rs.getDate("moment"));
				
				boardList.add(boardvo);
			}
		
		} catch (Exception e) {
			System.out.println(" BoardDAO selectList() ERR : " + e.getMessage());
		} finally {
			close(this.rs, this.pstmt, this.conn);
		}
		return boardList;
	}
	
	//한개
	public BoardVO selectOne(BoardVO boardvo) {
		try {
			Class.forName(this.JDBC_DRIVER);
			this.conn = DriverManager.getConnection(this.DB_URL, this.DB_ID, this.DB_PWD);
		
			String query = "SELECT q.idx, q.user_id, i.category, q.questionContent, q.moment, q.item_idx, q.answer FROM qna q JOIN item i ON q.item_idx = i.idx WHERE q.idx = ?";
			this.pstmt = this.conn.prepareStatement(query);
			this.pstmt.setInt(1, boardvo.getIdx());
			this.rs = this.pstmt.executeQuery();
			
			if(this.rs.next()) {
				//idx, user_id, category, item_idx, 
				//questionTitle, questionContent, answer, moment
				
				boardvo.setIdx(this.rs.getInt("idx"));
				boardvo.setUser_id(this.rs.getString("user_id"));
				boardvo.setCategory(this.rs.getString("category"));
				boardvo.setItem_idx(this.rs.getInt("item_idx"));
				boardvo.setQuestionContent(this.rs.getString("questionContent"));
				boardvo.setAnswer(this.rs.getString("answer"));
				boardvo.setMoment(this.rs.getDate("moment"));
			}
			
		} catch (Exception e) {
			System.out.println("selectOne() ERR : " + e.getMessage());
		} finally {
			close(this.rs, this.pstmt, this.conn);
		}
		return boardvo;
	}
	
	//수정
	public void update(BoardVO boardvo) {
		try {
			Class.forName(this.JDBC_DRIVER);
			this.conn = DriverManager.getConnection(this.DB_URL, this.DB_ID, this.DB_PWD);
			
			String query = "update qna set answer =? where idx=?";
			
			this.pstmt = this.conn.prepareStatement(query);
			
			this.pstmt.setString(1, boardvo.getAnswer());
			this.pstmt.setInt(2, boardvo.getIdx());
			int n = this.pstmt.executeUpdate();
			
			if(n>0) {
				System.out.println("=> UPDATE  SUCCESS");
			}
			
		} catch (Exception e) {
			System.out.println("update() ERR : " + e.getMessage());
		} finally {
			close(this.rs, this.pstmt, this.conn);
		}
		
	}
	
	//삭제
	public void delete(BoardVO boardvo) {
		try {
			Class.forName(this.JDBC_DRIVER);
			this.conn = DriverManager.getConnection(this.DB_URL, this.DB_ID, this.DB_PWD);
			
			String query = "delete from qna where idx=?";
			
			this.pstmt = this.conn.prepareStatement(query);
			this.pstmt.setInt(1, boardvo.getIdx());
			int n = this.pstmt.executeUpdate();
			
			if(n >0) {
				System.out.println("=> DELETE SUCCESS");
			}
			
		} catch (Exception e) {
			System.out.println("=> DELETE SUCCESS");
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
