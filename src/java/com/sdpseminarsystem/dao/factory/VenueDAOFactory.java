package com.sdpseminarsystem.dao.factory;

import java.sql.SQLException;

import com.sdpseminarsystem.dao.IVenueDAO;
import com.sdpseminarsystem.dao.impl.VenueDAOProxy;

/**
 * Provides method to get an instance of {@code IVenueDAO}
 * 
 * @author Leo Lee
 * @see com.sdpseminarsystem.dao.IVenueDAO
 * @since 1.0
 */
public final class VenueDAOFactory {
    
    private VenueDAOFactory() {}
    
    /**
     * Gets an instance of {@code IVenueDAO}
     * 
     * @return an instance of {@code IVenueDAO}
     * @throws SQLException if a database access error occurs.
     */
    public static IVenueDAO getInstance() throws SQLException {
        return new VenueDAOProxy();
    }
}
