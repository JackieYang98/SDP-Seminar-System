package com.sdpseminarsystem.dbc;

import java.sql.*;

public class DatabaseConnector {
	// JDBC driver name and database URL
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/sdp_seminar_system?useSSL=false&allowPublicKeyRetrieval=true";
	
	// username and password of database;
	private static final String USERNAME = "root";
	private static final String PASSWORD = "oUi!k!Cv%5$Hr$v0";
	
	private Connection conn = null;
	
	static {
		// register JDBC driver
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public DatabaseConnector() throws SQLException {
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
}
