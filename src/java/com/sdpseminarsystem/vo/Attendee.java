package com.sdpseminarsystem.vo;

import java.io.Serializable;

/**
 * Provides the value object of attendee entity.
 * 
 * @author Leo Lee
 * @see com.sdpseminarsystem.dao.IAttendeeDAO
 * @see com.sdpseminarsystem.dao.impl.AttendeeDAOImpl
 * @see com.sdpseminarsystem.dao.impl.AttendeeDAOProxy
 * @see com.sdpseminarsystem.nametag.NameTag
 * @see com.sdpseminarsystem.servlet.AttendeeServlet
 * @since 1.0
 */
public class Attendee implements Serializable {
    
    private static final long serialVersionUID = -350294326949380782L;
    
    private Integer attendeeId;
    private String attendeeEmail;
    private String attendeePhone;
    private String attendeeFirstName;
    private String attendeeLastName;
    private Character attendeeState;
    
    /**
     * Constructs a new {@code Attendee}. A no-parameter constructor follows the
     * JavaBean API conventions.
     */
    public Attendee() {}
    
    /**
     * Gets the attendee ID of this {@code Attendee}.
     * 
     * @return attendee ID.
     * @see #setAttendeeId(Integer attendeeId)
     */
    public Integer getAttendeeId() {
        return attendeeId;
    }
    
    /**
     * Sets the attendee ID for this {@code Attendee}.
     * 
     * @param attendeeId attendee ID.
     * @see #getAttendeeId()
     */
    public void setAttendeeId(Integer attendeeId) {
        this.attendeeId = attendeeId;
    }
    
    /**
     * Gets the email of this {@code Attendee}.
     * 
     * @return attendee email.
     * @see #setAttendeeEmail(String attendeeEmail)
     */
    public String getAttendeeEmail() {
        return attendeeEmail;
    }
    
    /**
     * Sets the email for this {@code Attendee}.
     * 
     * @param attendeeEmail attendee email.
     * @see #getAttendeeEmail()
     */
    public void setAttendeeEmail(String attendeeEmail) {
        this.attendeeEmail = attendeeEmail;
    }
    
    /**
     * Gets the phone of this {@code Attendee}.
     * 
     * @return attendee phone.
     * @see #setAttendeePhone(String attendeePhone)
     */
    public String getAttendeePhone() {
        return attendeePhone;
    }
    
    /**
     * Sets the phone for this {@code Attendee}.
     * 
     * @param attendeePhone attendee phone.
     * @see #getAttendeePhone()
     */
    public void setAttendeePhone(String attendeePhone) {
        this.attendeePhone = attendeePhone;
    }
    
    /**
     * Gets the first name of this {@code Attendee}.
     * 
     * @return attendee first name.
     * @see #setAttendeeFirstName(String attendeeFirstName)
     */
    public String getAttendeeFirstName() {
        return attendeeFirstName;
    }
    
    /**
     * Sets the first name for this {@code Attendee}.
     * 
     * @param attendeeFirstName attendee first name.
     * @see #getAttendeeFirstName()
     */
    public void setAttendeeFirstName(String attendeeFirstName) {
        this.attendeeFirstName = attendeeFirstName;
    }
    
    /**
     * Gets the last name of this {@code Attendee}.
     * 
     * @return attendee last name.
     * @see #setAttendeeLastName(String attendeeLastName)
     */
    public String getAttendeeLastName() {
        return attendeeLastName;
    }
    
    /**
     * Sets the last name for this {@code Attendee}.
     * 
     * @param attendeeLastName attendee last name.
     * @see #getAttendeeLastName()
     */
    public void setAttendeeLastName(String attendeeLastName) {
        this.attendeeLastName = attendeeLastName;
    }
    
    /**
     * Gets the attendee state of this {@code Attendee}.
     * 
     * @return attendee state. {@code 'i'} for interested; {@code 'a'} for attended.
     * @see #setAttendeeState(Character attendeeState)
     */
    public Character getAttendeeState() {
        return attendeeState;
    }
    
    /**
     * Sets the attendee state for this {@code Attendee}.
     * 
     * @param attendeeState attendee state. {@code 'i'} for interested; {@code 'a'}
     *                      for attended.
     * @see #getAttendeeState()
     */
    public void setAttendeeState(Character attendeeState) {
        this.attendeeState = attendeeState;
    }
}
