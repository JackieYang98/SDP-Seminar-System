package com.sdpseminarsystem.dao;

import java.sql.SQLException;
import java.util.List;

import com.sdpseminarsystem.vo.Venue;

/**
 * Provides useful methods to retrieve and manipulate the speaker entity in the
 * database.
 * 
 * @author Leo Lee
 * @since 1.0
 * @see com.sdpseminarsystem.vo.Venue
 */
public interface IVenueDAO {
    
    /**
     * Retrieves all venues in the database.
     * 
     * @return a list of all venues.
     * @throws SQLException if a database access error occurs.
     */
    public List<Venue> findAll() throws SQLException;
    
    /**
     * Retrieves all venues belonged to a specific host in the database.
     * 
     * @param hostId ID of the host.
     * @return a list of all venues of the user.
     * @throws SQLException if a database access error occurs.
     * @see com.sdpseminarsystem.vo.User
     */
    public List<Venue> findByUserHostId(int hostId) throws SQLException;
    
    /**
     * Retrieves the venue with the specific ID from the database.
     * 
     * @param venueId ID of the venue wanted.
     * @return venue of the specific ID.
     * @throws SQLException if a database access error occurs.
     */
    public Venue findById(int venueId) throws SQLException;
}
