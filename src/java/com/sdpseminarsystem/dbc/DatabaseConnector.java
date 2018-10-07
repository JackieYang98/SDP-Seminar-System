package com.sdpseminarsystem.dbc;

import java.sql.*;

/**
 * Establishes and provides a connection (session) with the database. Connection
 * is used to execute SQL statements and return results within the context of
 * the connection.
 * <p>
 * When this class is initialised in fist time, {@code com.mysql.cj.jdbc.Driver}
 * will be initialised to register JDBC driver.
 * <p>
 * Database has been set not using SSL and allowing public key retrieval.
 * 
 * @author Leo Lee
 * @since 1.0
 * @see com.mysql.cj.jdbc.Driver
 * @see java.sql.Connection
 * @see java.sql.SQLException
 */
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
    
    /**
     * Constructs a new {@code DatabaseConnector}.
     * <p>
     * Attempts to establish a connection to the database. Selected JDBC driver
     * should be registered before establishing.
     * 
     * @throws SQLException if a database access error occurs.
     * @see java.sql.DriverManager#getConnection(String)
     */
    public DatabaseConnector() throws SQLException {
        // open link
        conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }
    
    /**
     * Gets the connection (session) to the database.
     * 
     * @return connection (session).
     * @see java.sql.Connection
     */
    public Connection getConnection() {
        return conn;
    }
    
    /**
     * Closes {@code Connection} of this {@code DatabaseConnector}.
     * <p>
     * Releases {@code Connection} object's database and JDBC resources immediately.
     * 
     * @throws SQLException if a database access error occurs.
     * @see java.sql.Connection#close()
     */
    public void close() throws SQLException {
        // close connection
        if (conn != null)
            conn.close();
    }
}
