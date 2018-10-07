package com.sdpseminarsystem.dao;

import java.sql.SQLException;
import java.util.List;

import com.sdpseminarsystem.vo.*;

/**
 * Provides useful methods to retrieve and manipulate the seminar entity in the
 * database.
 * 
 * @author Leo Lee
 * @since 1.0
 * @see com.sdpseminarsystem.vo.Seminar
 */
public interface ISeminarDAO {
    
    /**
     * Creates a new seminar in the database.
     * 
     * @param seminar seminar needed to be created.
     * @return {@code true} if creation is successful; {@code false} if creation
     *         fails.
     * @throws NullPointerException if {@code seminar} is {@code null}.
     * @throws SQLException         if a database access error occurs.
     */
    public int create(Seminar seminar) throws SQLException;
    
    /**
     * Retrieves all seminars in the database.
     * 
     * @return a list of all seminars.
     * @throws SQLException if a database access error occurs.
     */
    public List<Seminar> findAll() throws SQLException;
    
    /**
     * Retrieves all seminars in the database and sort them by date.
     * 
     * @return a list of all seminars sorted by venue.
     * @throws SQLException if a database access error occurs.
     */
    public List<Seminar> findAllSortByDate() throws SQLException;
    
    /**
     * Retrieves all seminars in the database and sort them by venue.
     * 
     * @return a list of all seminars sorted by venue.
     * @throws SQLException if a database access error occurs.
     */
    public List<Seminar> findAllSortByVenue() throws SQLException;
    
    /**
     * Retrieves the seminar with the specific ID from the database.
     * 
     * @param seminarId ID of the seminar wanted.
     * @return seminar of the specific ID.
     * @throws SQLException if a database access error occurs.
     */
    public Seminar findById(int seminarId) throws SQLException;
    
    /**
     * Retrieves all seminars organised/host by a specific user in the database.
     * 
     * @param user the user that seminar belongs to.
     * @return a list of all seminars of the user.
     * @throws SQLException if a database access error occurs.
     * @see com.sdpseminarsystem.vo.User
     */
    public List<Seminar> findByUser(User user) throws SQLException;
    
    /**
     * Modifies the existing seminar in the database.
     * <p>
     * Property {@code seminarId} is used to specify the record in the database;
     * following properties of {@code seminar} will be update:
     * <ul>
     * <li>{@code Venue.VenueId}</li>
     * <li>{@code SeminarTitle}</li>
     * <li>{@code SeminarDescription}</li>
     * <li>{@code SeminarDate}</li>
     * <li>{@code SeminarLastMins}</li>
     * </ul>
     * 
     * @param seminar modified seminar.
     * @return {@code true} if updating is successful; {@code false} if updating
     *         fails.
     * @throws NullPointerException if {@code seminar} is {@code null}.
     * @throws SQLException         if a database access error occurs.
     * @see com.sdpseminarsystem.vo.Venue
     */
    public boolean update(Seminar seminar) throws SQLException;
    
    /**
     * Delete a specific seminar in database.
     * <p>
     * Property {@code seminarId} is used to specify the record in the database.
     * 
     * @param seminar seminar needed to be deleted.
     * @return {@code true} if deletion is successful; {@code false} if deletion
     *         fails.
     * @throws NullPointerException if {@code seminar} is {@code null}.
     * @throws SQLException         if a database access error occurs.
     */
    public boolean delete(Seminar seminar) throws SQLException;
}
