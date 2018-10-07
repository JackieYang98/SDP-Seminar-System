package com.sdpseminarsystem.dao.impl;

import java.sql.SQLException;

import com.sdpseminarsystem.dbc.DatabaseConnector;

/**
 * Super class of DAO proxy classes. Holds a {@link DatabaseConnector} object to
 * serve needs of implementations.
 * 
 * @author Leo Lee
 * @since 1.0
 * @see com.sdpseminarsystem.dbc.DatabaseConnector
 */
public abstract class DAOProxy {
    
    protected DatabaseConnector dbc;
    
    /**
     * Constructs a new DAO proxy class.
     * 
     * @throws SQLException if a database access error occurs.
     */
    public DAOProxy() throws SQLException {
        dbc = new DatabaseConnector();
    }
}
