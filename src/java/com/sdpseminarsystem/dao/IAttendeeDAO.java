package com.sdpseminarsystem.dao;

import java.sql.SQLException;
import java.util.List;

import com.sdpseminarsystem.vo.Attendee;

/**
 * Provides useful methods to retrieve and manipulate the attendee entity in the
 * database.
 * 
 * @author Leo Lee
 * @since 1.0
 * @see com.sdpseminarsystem.vo.Attendee
 */
public interface IAttendeeDAO {
    
    /**
     * Creates a new attendee in the database.
     * 
     * @param attendee  attendee needed to be created.
     * @param seminarId ID of the seminar {@code attendee} belongs to.
     * @return {@code true} if creation is successful; {@code false} if creation
     *         fails.
     * @throws NullPointerException if {@code attendee} is {@code null}.
     * @throws SQLException         if a database access error occurs.
     * @see com.sdpseminarsystem.vo.Seminar
     */
    public boolean create(Attendee attendee, int seminarId) throws SQLException;
    
    /**
     * Retrieves all attendees of a specific seminar in database.
     * 
     * @param seminarId seminar ID
     * @return a list of all attendees of the seminar.
     * @throws SQLException if a database access error occurs.
     * @see com.sdpseminarsystem.vo.Seminar
     */
    public List<Attendee> findAllBySeminar(int seminarId) throws SQLException;
    
    /**
     * Retrieves the attendee with the specific ID from the database.
     * 
     * @param attendeeId ID of the attendee wanted.
     * @return attendee of the specific ID.
     * @throws SQLException if a database access error occurs.
     */
    public Attendee findById(int attendeeId) throws SQLException;
    
    /**
     * Retrieves the attendee of a specific seminar with the attendee email.
     * 
     * @param seminarId     seminar ID.
     * @param attendeeEmail email of the attendee wanted.
     * @return attendee of the specific email and seminar.
     * @throws SQLException if a database access error occurs.
     * @see com.sdpseminarsystem.vo.Seminar
     */
    public Attendee findBySeminarAndEmail(int seminarId, String attendeeEmail) throws SQLException;
    
    /**
     * Modifies the existing attendee in the database.
     * <p>
     * Property {@code attendeeId} is used to specify the record in the database;
     * following properties of {@code attendee} will be update:
     * <ul>
     * <li>{@code AttendeeEmail}</li>
     * <li>{@code AttendeePhone}</li>
     * <li>{@code AttendeeFirstName}</li>
     * <li>{@code AttendeeLastName}</li>
     * <li>{@code AttendeeState}</li>
     * </ul>
     * 
     * @param attendee modified attendee.
     * @return {@code true} if updating is successful; {@code false} if updating
     *         fails.
     * @throws NullPointerException if {@code attendee} is {@code null}.
     * @throws SQLException         if a database access error occurs.
     */
    public boolean update(Attendee attendee) throws SQLException;
    
    /**
     * Delete a specific attendee in database.
     * <p>
     * Property {@code attendeeId} is used to specify the record in the database.
     * 
     * @param attendee attendee needed to be deleted.
     * @return {@code true} if deletion is successful; {@code false} if deletion
     *         fails.
     * @throws NullPointerException if {@code attendee} is {@code null}.
     * @throws SQLException         if a database access error occurs.
     */
    public boolean delete(Attendee attendee) throws SQLException;
}
