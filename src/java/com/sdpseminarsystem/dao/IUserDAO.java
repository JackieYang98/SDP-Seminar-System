package com.sdpseminarsystem.dao;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.List;

import com.sdpseminarsystem.vo.User;

/**
 * Provides useful methods to retrieve and manipulate the user entity in the
 * database.
 * 
 * @author Leo Lee
 * @since 1.0
 * @see com.sdpseminarsystem.vo.User
 */
public interface IUserDAO {
    
    /**
     * Creates a new user in the database.
     * 
     * @param user user needed to be created.
     * @return {@code true} if creation is successful; {@code false} if creation
     *         fails.
     * @throws InvalidKeySpecException  if an error of invalid Keys (invalid
     *                                  encoding, wrong length, uninitialised, etc)
     *                                  occurs.
     * @throws NoSuchAlgorithmException if a particular cryptographic algorithm
     *                                  requested is not available in the
     *                                  environment.
     * @throws NullPointerException     if {@code user} is {@code null}.
     * @throws SQLException             if a database access error occurs.
     */
    public boolean create(User user) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException;
    
    /**
     * Retrieves all users in the database.
     * 
     * @return a list of all users.
     * @throws SQLException if a database access error occurs.
     */
    public List<User> findAll() throws SQLException;
    
    /**
     * Retrieves the user with the specific ID from the database.
     * 
     * @param userId ID of the user wanted.
     * @return user of the specific ID.
     * @throws SQLException if a database access error occurs.
     */
    public User findById(String userId) throws SQLException;
    
    /**
     * Modifies the existing user in the database.
     * <p>
     * Property {@code userId} is used to specify the record in the database;
     * following properties of {@code user} will be update:
     * <ul>
     * <li>{@code UserTypeFlag}</li>
     * </ul>
     * 
     * @param user modified user.
     * @return {@code true} if updating is successful; {@code false} if updating
     *         fails.
     * @throws NullPointerException if {@code user} is {@code null}.
     * @throws SQLException         if a database access error occurs.
     */
    public boolean update(User user) throws SQLException;
    
    /**
     * Delete a specific user in database.
     * <p>
     * Property {@code userId} is used to specify the record in the database.
     * 
     * @param user user needed to be deleted.
     * @return {@code true} if deletion is successful; {@code false} if deletion
     *         fails.
     * @throws NullPointerException if {@code user} is {@code null}.
     * @throws SQLException         if a database access error occurs.
     */
    public boolean delete(User user) throws SQLException;
    
    /**
     * Verify the user by comparing the passwords of object and record in the
     * database.
     * <p>
     * Property {@code userId} is used to specify the record in the database;
     * <p>
     * Property {@code userPassword} will be hashed by
     * {@link com.sdpseminarsystem.login.PasswordHash} before comparing.
     * 
     * @param user user needed to be verified.
     * @return {@code true} if the user is verified; {@code false} if the user is
     *         not.
     * @throws InvalidKeySpecException  if an error of invalid Keys (invalid
     *                                  encoding, wrong length, uninitialised, etc)
     *                                  occurs.
     * @throws NoSuchAlgorithmException if a particular cryptographic algorithm
     *                                  requested is not available in the
     *                                  environment.
     * @throws NullPointerException     if {@code user} is {@code null}.
     * @throws SQLException             if a database access error occurs.
     */
    public boolean verify(User user) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException;
}
