package com.sdpseminarsystem.dao;

import java.sql.SQLException;
import java.util.List;

import com.sdpseminarsystem.vo.Speaker;

/**
 * Provides useful methods to retrieve and manipulate the speaker entity in the
 * database.
 * 
 * @author Leo Lee
 * @since 1.0
 * @see com.sdpseminarsystem.vo.Speaker
 */
public interface ISpeakerDAO {
    
    /**
     * Creates a new speaker in the database.
     * 
     * @param speaker   speaker needed to be created.
     * @param seminarId ID of the seminar {@code speaker} belongs to.
     * @return {@code true} if creation is successful; {@code false} if creation
     *         fails.
     * @throws NullPointerException if {@code speaker} is {@code null}.
     * @throws SQLException         if a database access error occurs.
     */
    public boolean create(Speaker speaker, int seminarId) throws SQLException;
    
    /**
     * Retrieves all speakers of a specific seminar in database.
     * 
     * @param seminarId seminar ID
     * @return a list of all speakers of the seminar.
     * @throws SQLException if a database access error occurs.
     * @see com.sdpseminarsystem.vo.Seminar
     */
    public List<Speaker> findAllBySeminar(int seminarId) throws SQLException;
    
    /**
     * Retrieves the speakers with the specific ID from the database.
     * 
     * @param speakerId ID of the speaker wanted.
     * @return speaker of the specific ID.
     * @throws SQLException if a database access error occurs.
     */
    public Speaker findById(int speakerId) throws SQLException;
    
    /**
     * Modifies the existing speaker in the database.
     * <p>
     * Property {@code speakerId} is used to specify the record in the database;
     * following properties of {@code speaker} will be update:
     * <ul>
     * <li>{@code SpeakerName}</li>
     * <li>{@code SpeakerBiography}</li>
     * </ul>
     * 
     * @param speaker modified speaker.
     * @return {@code true} if updating is successful; {@code false} if updating
     *         fails.
     * @throws NullPointerException if {@code speaker} is {@code null}.
     * @throws SQLException         if a database access error occurs.
     */
    public boolean update(Speaker speaker) throws SQLException;
    
    /**
     * Delete a specific speaker in database.
     * <p>
     * Property {@code speakerId} is used to specify the record in the database.
     * 
     * @param speaker speaker needed to be deleted.
     * @return {@code true} if deletion is successful; {@code false} if deletion
     *         fails.
     * @throws NullPointerException if {@code speaker} is {@code null}.
     * @throws SQLException         if a database access error occurs.
     */
    public boolean delete(Speaker speaker) throws SQLException;
}
