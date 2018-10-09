package com.sdpseminarsystem.dao.factory;

import java.sql.SQLException;

import com.sdpseminarsystem.dao.IUserDAO;
import com.sdpseminarsystem.dao.impl.UserDAOProxy;

/**
 * Provides method to get an instance of {@code IUserDAO}
 * 
 * @author Leo Lee
 * @see com.sdpseminarsystem.dao.IUserDAO
 * @since 1.0
 */
public final class UserDAOFactory {
    
    private UserDAOFactory() {}
    
    /**
     * Gets an instance of {@code IUserDAO}
     * 
     * @return an instance of {@code IUserDAO}
     * @throws SQLException if a database access error occurs.
     */
    public static IUserDAO getInstance() throws SQLException {
        return new UserDAOProxy();
    }
}
