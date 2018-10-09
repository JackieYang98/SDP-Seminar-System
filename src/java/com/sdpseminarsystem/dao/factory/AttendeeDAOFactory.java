package com.sdpseminarsystem.dao.factory;

import java.sql.SQLException;

import com.sdpseminarsystem.dao.IAttendeeDAO;
import com.sdpseminarsystem.dao.impl.AttendeeDAOProxy;

/**
 * Provides method to get an instance of {@code IAttendeeDAO}
 * 
 * @author Leo Lee
 * @see com.sdpseminarsystem.dao.IAttendeeDAO
 * @since 1.0
 */
public final class AttendeeDAOFactory {
    
    private AttendeeDAOFactory() {}
    
    /**
     * Gets an instance of {@code IAttendeeDAO}
     * 
     * @return an instance of {@code IAttendeeDAO}
     * @throws SQLException if a database access error occurs.
     */
    public static IAttendeeDAO getInstance() throws SQLException {
        return new AttendeeDAOProxy();
    }
}
