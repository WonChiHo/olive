package com.coh.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnector {
	private static final String DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/olive";
	private Connection conn = null;
	
	public MySQLConnector() {
		// TODO Auto-generated constructor stub
	}
	
	public Connection getConnector() {
		if (conn == null) {
			try {
				Class.forName(DRIVER_PATH);
				conn = DriverManager.getConnection(DB_URL, "root", "1234");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	public void close() {
		try {
			conn.close();
			conn = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
