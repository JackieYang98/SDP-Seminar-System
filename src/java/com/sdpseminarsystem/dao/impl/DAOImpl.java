package com.sdpseminarsystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Super class of DAO implementations. Holds a {@code Connection} and a
 * {@code PreparedStatement} object to serve needs of implementations.
 * 
 * @author Leo Lee
 * @since 1.0
 * @see java.sql.Connection
 * @see java.sql.PreparedStatement
 */
public abstract class DAOImpl {
    
    /**
     * Connection (session).
     */
    protected Connection conn;
    /**
     * PreparedStatement.
     */
    protected PreparedStatement stmt = null;
    
    /**
     * Constructs a new DAO implementation class.
     * 
     * @param conn given {@code Connection}
     */
    public DAOImpl(Connection conn) {
        this.conn = conn;
    }
}
