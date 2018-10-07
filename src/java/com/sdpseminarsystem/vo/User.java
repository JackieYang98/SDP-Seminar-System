package com.sdpseminarsystem.vo;

import java.io.Serializable;

/**
 * Provides the value object of user entity.
 * 
 * @author Leo Lee
 * @see com.sdpseminarsystem.dao.IUserDAO
 * @see com.sdpseminarsystem.dao.impl.UserDAOImpl
 * @see com.sdpseminarsystem.dao.impl.UserDAOProxy
 * @see com.sdpseminarsystem.servlet.LoginServlet
 * @see com.sdpseminarsystem.servlet.LogoutServlet
 * @see com.sdpseminarsystem.servlet.UserServlet
 * @since 1.0
 */
public class User implements Serializable {
    
    private static final long serialVersionUID = 6086326671389480875L;
    
    private String userId;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userPassword;
    private Character userTypeFlag;
    
    /**
     * Constructs a new {@code User}. A no-parameter constructor follows the
     * JavaBean API conventions.
     */
    public User() {}
    
    /**
     * Gets the user ID of this {@code User}.
     * 
     * @return user ID.
     * @see #setUserId(String userId)
     */
    public String getUserId() {
        return userId;
    }
    
    /**
     * Sets the user ID for this {@code User}.
     * 
     * @param userId user ID.
     * @see #getUserId()
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    /**
     * Gets the first name of this {@code User}.
     * 
     * @return user first name.
     * @see #setUserFirstName(String userFirstName)
     */
    public String getUserFirstName() {
        return userFirstName;
    }
    
    /**
     * Sets the first name for this {@code User}.
     * 
     * @param userFirstName first name.
     * @see #getUserFirstName()
     */
    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }
    
    /**
     * Gets the last name of this {@code User}.
     * 
     * @return user last name.
     * @see #setUserLastName(String userLastName)
     */
    public String getUserLastName() {
        return userLastName;
    }
    
    /**
     * Sets the last name for this {@code User}.
     * 
     * @param userLastName user last name.
     * @see #getUserLastName()
     */
    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }
    
    /**
     * Gets the email of this {@code User}.
     * 
     * @return user email.
     * @see #setUserEmail(String userEmail)
     */
    public String getUserEmail() {
        return userEmail;
    }
    
    /**
     * Sets the email for this {@code User}.
     * 
     * @param userEmail user email.
     * @see #getUserEmail()
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    
    /**
     * Gets the plaintext password of this {@code User}.
     * 
     * @return user password.
     * @see #setUserPassword(String userPassword)
     */
    public String getUserPassword() {
        return userPassword;
    }
    
    /**
     * Sets the plaintext password for this {@code User}.
     * 
     * @param userPassword password.
     * @see #getUserPassword()
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    /**
     * Gets the user type flag of this {@code User}.
     * 
     * @return user type flag. {@code 'a'} for system administrator; {@code 'o'} for
     *         organiser; {@code 'h'} for host.
     * @see #setUserTypeFlag(Character userTypeFlag)
     */
    public Character getUserTypeFlag() {
        return userTypeFlag;
    }
    
    /**
     * Sets the user type flag for this {@code User}.
     * 
     * @param userTypeFlag user type flag. {@code 'a'} for system administrator;
     *                     {@code 'o'} for organiser; {@code 'h'} for host.
     * @see #getUserTypeFlag()
     */
    public void setUserTypeFlag(Character userTypeFlag) {
        this.userTypeFlag = userTypeFlag;
    }
}
