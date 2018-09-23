package com.sdpseminarsystem.dbc;

import java.sql.*;

public class DatabaseConnector {
	// JDBC driver name and database URL
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/sdp_seminar_system?useSSL=false";
	
	// username and password of database;
	private static final String USERNAME = "root";
	private static final String PASSWORD = "sss";
	
	private Connection conn = null;
	
	public DatabaseConnector() throws ClassNotFoundException, SQLException {
		// register JDBC driver
		Class.forName(JDBC_DRIVER);
		// open link
		conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
	}
	
	public Connection getConnection() throws SQLException {
		return conn;
	}
	
	public void close() throws SQLException {
		// close connection
			if(conn != null)
				conn.close();
	}
	
//	protected void finalize() {
//		try {
//			close();
//		} catch (SQLException e) {
//			// TODO automatically generated catch block
//			e.printStackTrace();
//		}
//	}
}
