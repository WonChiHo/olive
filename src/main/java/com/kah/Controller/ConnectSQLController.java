package com.kah.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectSQLController {
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/";
	private final String ID = "root";
	private final String PW = "1234";
	private final String DB_NAME = "olive";
	Connection Connector = null;
	
	 
	public ConnectSQLController() {
		
	} // 기본생성자 END
	
	/** 드라이브 접속 */
    public Connection connectMYSQL() {
    	if (this.Connector == null) {
			try {
				Class.forName(DRIVER);
				this.Connector = DriverManager.getConnection(URL + DB_NAME, ID, PW);
				System.out.println("드라이브 접속 성공");
			} catch (ClassNotFoundException | SQLException e) {
				System.err.println("MySQLConnector() ERR : " + e.getMessage());
			}
		}return this.Connector;
	}//connectMYSQL END
    
    
    /** Close 메서드 */
    public void close(ResultSet rs, PreparedStatement pstmt, Connection Connector) {
    	try {
    		
    		if (rs != null) {
    			rs.close();
    			}
    		
    		if (pstmt != null) {
    			pstmt.close();
    			}
    	
    		if (Connector != null) {
				Connector.close();
				}
    		
    	
			
		} catch (SQLException e) {
			System.err.println("close() => CLOSE ERR : " + e.getMessage());
		}
    }

}
