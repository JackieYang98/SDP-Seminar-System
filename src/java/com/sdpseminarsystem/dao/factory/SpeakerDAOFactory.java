package com.sdpseminarsystem.dao.factory;

import java.sql.SQLException;

import com.sdpseminarsystem.dao.ISpeakerDAO;
import com.sdpseminarsystem.dao.impl.SpeakerDAOProxy;

/**
 * Provides method to get an instance of {@code ISpeakerDAO}
 * 
 * @author Leo Lee
 * @see com.sdpseminarsystem.dao.ISpeakerDAO
 * @since 1.0
 */
public final class SpeakerDAOFactory {
    
    private SpeakerDAOFactory() {}
    
    /**
     * Gets an instance of {@code ISpeakerDAO}
     * 
     * @return an instance of {@code ISpeakerDAO}
     * @throws SQLException if a database access error occurs.
     */
    public static ISpeakerDAO getInstance() throws SQLException {
        return new SpeakerDAOProxy();
    }
}
