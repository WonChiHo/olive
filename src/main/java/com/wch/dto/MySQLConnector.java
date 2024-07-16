package com.wch.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** Connection 객체, 각종 close()  **/
public class MySQLConnector {

	private final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

	private final String DB_URL = "jdbc:mysql://localhost:3306/";
	private final String DB_NAME = "olive";
	private final String DB_MYSQL = DB_URL + DB_NAME;
	private final String MYSQL_ID = "root";
	private final String MYSQL_PW = "1234";
	
	private Connection connector = null;

	public MySQLConnector() {
	}

	public Connection connect() {
		if (this.connector == null) {
			try {
				Class.forName(DB_DRIVER);
				this.connector = DriverManager.getConnection(DB_MYSQL, MYSQL_ID, MYSQL_PW);
			} catch (ClassNotFoundException | SQLException e) {
				System.err.println("MySQLConnector() ERR : " + e.getMessage());
			}

		}
		return this.connector;

	}

	public void close(Connection connector) {
		if (connector != null) {
			try {
				this.connector.close();
				this.connector = null;
			} catch (SQLException e) {
				System.err.println("Connection CLOSE ERR : " + e.getMessage());
			}
		}
	}

	public void close(Connection connector, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt =null;
			}
			if (connector != null) {
				this.connector.close();
				this.connector = null;
			}
		} catch (SQLException e) {
			System.err.println("Connection, Statement, ResultSet CLOSE ERR : " + e.getMessage());
		}
	}
	
	public void close(Connection connector, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (pstmt != null) {
				pstmt.close();
				pstmt =null;
			}
			if (connector != null) {
				this.connector.close();
				this.connector = null;
			}
		} catch (SQLException e) {
			System.err.println("Connection, PreparedStatement, ResultSet CLOSE ERR : " + e.getMessage());
		}
	}
	
	public void close(Connection connector, PreparedStatement pstmt) {
		try {
			if (connector != null) {
				pstmt.close();
				pstmt =null;
			}
			if (connector != null) {
				this.connector.close();
				this.connector = null;
			}
		} catch (SQLException e) {
			System.err.println("Connection, PreparedStatement CLOSE ERR : " + e.getMessage());
		}
	}
	
	public void close(Connection connector, Statement stmt) {
		try {
			if (connector != null) {
				stmt.close();
				stmt = null;
			}
			if (connector != null) {
				this.connector.close();
				this.connector = null;
			}
		} catch (SQLException e) {
			System.err.println("Connection, Statement CLOSE ERR : " + e.getMessage());
		}
	}

}
