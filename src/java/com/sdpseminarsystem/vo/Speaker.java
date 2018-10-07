package com.sdpseminarsystem.vo;

import java.io.Serializable;

/**
 * Provides the value object of speaker entity.
 * 
 * @author Leo Lee
 * @see com.sdpseminarsystem.dao.ISpeakerDAO
 * @see com.sdpseminarsystem.dao.impl.SpeakerDAOImpl
 * @see com.sdpseminarsystem.dao.impl.SpeakerDAOProxy
 * @see com.sdpseminarsystem.servlet.CreateSeminarServlet
 * @since 1.0
 */
public class Speaker implements Serializable {
    
    private static final long serialVersionUID = 8137883080259761342L;
    
    private Integer speakerId;
    private String speakerName;
    private String speakerBiography;
    
    /**
     * Constructs a new {@code Speaker}. A no-parameter constructor follows the
     * JavaBean API conventions.
     */
    public Speaker() {}
    
    /**
     * Gets the speaker ID of this {@code Speaker}.
     * 
     * @return speaker ID.
     * @see #setSpeakerId(Integer speakerId)
     */
    public Integer getSpeakerId() {
        return speakerId;
    }
    
    /**
     * Sets the speaker ID for this {@code Speaker}.
     * 
     * @param speakerId speaker ID.
     * @see #getSpeakerId()
     */
    public void setSpeakerId(Integer speakerId) {
        this.speakerId = speakerId;
    }
    
    /**
     * Gets the name of this {@code Speaker}.
     * 
     * @return speaker name.
     * @see #setSpeakerName(String speakerName)
     */
    public String getSpeakerName() {
        return speakerName;
    }
    
    /**
     * Sets the name for this {@code Speaker}.
     * 
     * @param speakerName speaker name.
     * @see #getSpeakerName()
     */
    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }
    
    /**
     * Gets the biography of this {@code Speaker}.
     * 
     * @return speaker biography.
     * @see #setSpeakerBiography(String speakerBiography)
     */
    public String getSpeakerBiography() {
        return speakerBiography;
    }
    
    /**
     * Sets the biography for this {@code Speaker}.
     * 
     * @param speakerBiography speaker biography.
     * @see #getSpeakerBiography()
     */
    public void setSpeakerBiography(String speakerBiography) {
        this.speakerBiography = speakerBiography;
    }
}
