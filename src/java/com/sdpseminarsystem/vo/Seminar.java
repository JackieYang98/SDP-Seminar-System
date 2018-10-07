package com.sdpseminarsystem.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Provides the value object of seminar entity.
 * 
 * @author Leo Lee
 * @see User
 * @see Venue
 * @see com.sdpseminarsystem.dao.ISeminarDAO
 * @see com.sdpseminarsystem.dao.impl.SeminarDAOImpl
 * @see com.sdpseminarsystem.dao.impl.SeminarDAOProxy
 * @see com.sdpseminarsystem.servlet.CreateSeminarServlet
 * @since 1.0
 */
public class Seminar implements Serializable {
    
    private static final long serialVersionUID = -7728848261548449116L;
    
    private Integer seminarId;
    private Venue venue;
    private User userOrganiser;
    private User userHost;
    private String seminarTitle;
    private String seminarDescription;
    private Date seminarStartTime;
    private Integer seminarLastMins;
    /**
     * Constant for one minute in milliseconds.
     */
    private static final Long MIN = (long) (60 * 1000);
    
    /**
     * Constructs a new {@code Seminar}. A no-parameter constructor follows the
     * JavaBean API conventions.
     */
    public Seminar() {}
    
    /**
     * Gets the seminar ID of this {@code Seminar}.
     * 
     * @return seminar ID.
     * @see #setSeminarId(Integer seminarId)
     */
    public Integer getSeminarId() {
        return seminarId;
    }
    
    /**
     * Sets the seminar ID for this {@code Seminar}.
     * 
     * @param seminarId seminar ID.
     * @see #getSeminarId()
     */
    public void setSeminarId(Integer seminarId) {
        this.seminarId = seminarId;
    }
    
    /**
     * Gets the venue of this {@code Seminar}.
     * 
     * @return seminar venue.
     * @see #setVenue(Venue venue)
     * @see Venue
     */
    public Venue getVenue() {
        return venue;
    }
    
    /**
     * Sets the venue for this {@code Seminar}.
     * 
     * @param venue seminar venue.
     * @see #getVenue()
     * @see Venue
     */
    public void setVenue(Venue venue) {
        this.venue = venue;
    }
    
    /**
     * Gets the organiser of this {@code Seminar}.
     * 
     * @return seminar organiser.
     * @see #setUserOrganiser(User userOrganiser)
     * @see User
     */
    public User getUserOrganiser() {
        return userOrganiser;
    }
    
    /**
     * Sets the organiser for this {@code Seminar}.
     * 
     * @param userOrganiser seminar organiser.
     * @see #getUserOrganiser()
     * @see User
     */
    public void setUserOrganiser(User userOrganiser) {
        this.userOrganiser = userOrganiser;
    }
    
    /**
     * Gets the host of this {@code Seminar}.
     * 
     * @return seminar host.
     * @see #setUserHost(User userHost)
     * @see User
     */
    public User getUserHost() {
        return userHost;
    }
    
    /**
     * Sets the host for this {@code Seminar}.
     * 
     * @param userHost seminar host.
     * @see #getUserHost()
     * @see User
     */
    public void setUserHost(User userHost) {
        this.userHost = userHost;
    }
    
    /**
     * Gets the title of this {@code Seminar}.
     * 
     * @return seminar title.
     * @see #setSeminarTitle(String seminarTitle)
     */
    public String getSeminarTitle() {
        return seminarTitle;
    }
    
    /**
     * Sets the title for this {@code Seminar}.
     * 
     * @param seminarTitle seminar title.
     * @see #getSeminarTitle()
     */
    public void setSeminarTitle(String seminarTitle) {
        this.seminarTitle = seminarTitle;
    }
    
    /**
     * Gets the description of this {@code Seminar}.
     * 
     * @return seminar description.
     * @see #setSeminarDescription(String seminarDescription)
     */
    public String getSeminarDescription() {
        return seminarDescription;
    }
    
    /**
     * Sets the description for this {@code Seminar}.
     * 
     * @param seminarDescription seminar description.
     * @see #getSeminarDescription()
     */
    public void setSeminarDescription(String seminarDescription) {
        this.seminarDescription = seminarDescription;
    }
    
    /**
     * Gets the start time of this {@code Seminar}.
     * 
     * @return seminar start time.
     * @see #setSeminarStartTime(Date seminarStartTime)
     */
    public Date getSeminarStartTime() {
        return seminarStartTime;
    }
    
    /**
     * Sets the start time for this {@code Seminar}.
     * 
     * @param seminarStartTime seminar start time.
     * @see #getSeminarStartTime()
     */
    public void setSeminarStartTime(Date seminarStartTime) {
        this.seminarStartTime = seminarStartTime;
    }
    
    /**
     * Gets the duration of this {@code Seminar} in minutes.
     * 
     * @return seminar duration in minutes.
     * @see #setSeminarLastMins(Integer seminarLastMins)
     */
    public Integer getSeminarLastMins() {
        return seminarLastMins;
    }
    
    /**
     * Sets the duration for this {@code Seminar}.
     * 
     * @param seminarLastMins seminar duration in minutes.
     * @see #getSeminarLastMins()
     */
    public void setSeminarLastMins(Integer seminarLastMins) {
        this.seminarLastMins = seminarLastMins;
    }
    
    /**
     * Gets the end time of this {@code Seminar}. Calculate by seminar start time
     * and duration.
     * 
     * @return seminar end time. {@code null} if seminar start time and/or duration
     *         is {@code null}.
     * @see #getSeminarLastMins()
     * @see #setSeminarEndTime(Date seminarEndTime)
     */
    public Date getSeminarEndTime() {
        if (seminarStartTime == null || seminarLastMins == null)
            return null;
        return new Date(seminarStartTime.getTime() + seminarLastMins * MIN);
    }
    
    /**
     * Sets the seminar duration for this {@code Seminar} by its end time.
     * <p>
     * Alternative setter for seminar duration, which is calculated by seminar start
     * time of this {@code Seminar} and end time of parameter.
     * 
     * @param seminarEndTime seminar end time.
     * @throws NullPointerException if seminar start time of this {@code Seminar}
     *                              and/or {@code seminarEndTime} is {@code null}.
     * @see #getSeminarEndTime()
     * @see #setSeminarLastMins(Integer seminarLastMins)
     */
    public void setSeminarEndTime(Date seminarEndTime) {
        if (seminarStartTime == null)
            throw new NullPointerException();
        this.seminarLastMins = (int) ((seminarEndTime.getTime() - seminarStartTime.getTime()) / MIN);
    }
}
