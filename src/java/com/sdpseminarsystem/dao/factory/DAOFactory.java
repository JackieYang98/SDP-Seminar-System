package com.sdpseminarsystem.dao.factory;

import java.sql.SQLException;

import com.sdpseminarsystem.dao.*;

/**
 * Provides methods to get instances of DAO implementations.
 * <p>
 * An abstract factory class that generates instances of DAO implementations
 * from other specific factory classes.
 * 
 * @author Leo Lee
 * @see com.sdpseminarsystem.dao
 * @since 1.0
 */
public final class DAOFactory {
    
    private DAOFactory() {}
    
    /**
     * Gets an instance of {@code IUserDAO}
     * 
     * @return an instance of {@code IUserDAO}
     * @throws SQLException if a database access error occurs.
     * @see com.sdpseminarsystem.dao.IUserDAO
     */
    public static IUserDAO getInstanceOfUserDAO() throws SQLException {
        return UserDAOFactory.getInstance();
    }
    
    /**
     * Gets an instance of {@code IVenueDAO}
     * 
     * @return an instance of {@code IVenueDAO}
     * @throws SQLException if a database access error occurs.
     * @see com.sdpseminarsystem.dao.IVenueDAO
     */
    public static IVenueDAO getInstanceOfVenueDAO() throws SQLException {
        return VenueDAOFactory.getInstance();
    }
    
    /**
     * Gets an instance of {@code ISeminarDAO}
     * 
     * @return an instance of {@code ISeminarDAO}
     * @throws SQLException if a database access error occurs.
     * @see com.sdpseminarsystem.dao.ISeminarDAO
     */
    public static ISeminarDAO getInstanceOfSeminarDAO() throws SQLException {
        return SeminarDAOFactory.getInstance();
    }
    
    /**
     * Gets an instance of {@code IAttendeeDAO}
     * 
     * @return an instance of {@code IAttendeeDAO}
     * @throws SQLException if a database access error occurs.
     * @see com.sdpseminarsystem.dao.IAttendeeDAO
     */
    public static IAttendeeDAO getInstanceOfAttendeeDAO() throws SQLException {
        return AttendeeDAOFactory.getInstance();
    }
    
    /**
     * Gets an instance of {@code ISpeakerDAO}
     * 
     * @return an instance of {@code ISpeakerDAO}
     * @throws SQLException if a database access error occurs.
     * @see com.sdpseminarsystem.dao.ISpeakerDAO
     */
    public static ISpeakerDAO getInstanceOfSpeakerDAO() throws SQLException {
        return SpeakerDAOFactory.getInstance();
    }
}
