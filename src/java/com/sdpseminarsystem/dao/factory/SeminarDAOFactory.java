package com.sdpseminarsystem.dao.factory;

import java.sql.SQLException;

import com.sdpseminarsystem.dao.ISeminarDAO;
import com.sdpseminarsystem.dao.impl.SeminarDAOProxy;

/**
 * Provides method to get an instance of {@code ISeminarDAO}
 * 
 * @author Leo Lee
 * @see com.sdpseminarsystem.dao.ISeminarDAO
 * @since 1.0
 */
public class SeminarDAOFactory {
    
    private SeminarDAOFactory() {}
    
    /**
     * Gets an instance of {@code ISeminarDAO}
     * 
     * @return an instance of {@code ISeminarDAO}
     * @throws SQLException if a database access error occurs.
     */
    public static ISeminarDAO getInstance() throws SQLException {
        return new SeminarDAOProxy();
    }
}
