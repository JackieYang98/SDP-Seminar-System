package com.sdpseminarsystem.vo;

import java.io.Serializable;

/**
 * Provides the value object of venue entity.
 * 
 * @author Leo Lee
 * @since 1.0
 * @see com.sdpseminarsystem.dao.IVenueDAO
 * @see com.sdpseminarsystem.dao.impl.VenueDAOImpl
 * @see com.sdpseminarsystem.dao.impl.VenueDAOProxy
 */
public class Venue implements Serializable {
    
    private static final long serialVersionUID = -1510807057622218077L;
    
    private Integer venueId;
    private String venueName;
    private String venueLocation;
    private Integer venueCapacity;
    
    /**
     * Constructs a new {@code Venue}. A no-parameter constructor follows the
     * JavaBean API conventions.
     */
    public Venue() {}
    
    /**
     * Gets the venue ID of this {@code Venue}.
     * 
     * @return venue ID.
     * @see #setVenueId(Integer venueId)
     */
    public Integer getVenueId() {
        return venueId;
    }
    
    /**
     * Sets the venue ID for this {@code Venue}.
     * 
     * @param venueId venue ID.
     * @see #getVenueId()
     */
    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }
    
    /**
     * Gets the name of this {@code Venue}.
     * 
     * @return venue name.
     * @see #setVenueName(String venueName)
     */
    public String getVenueName() {
        return venueName;
    }
    
    /**
     * Sets the name for this {@code Venue}.
     * 
     * @param venueName venue name.
     * @see #getVenueName()
     */
    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }
    
    /**
     * Gets the location of this {@code Venue}.
     * 
     * @return venue location.
     * @see #setVenueLocation(String venueLocation)
     */
    public String getVenueLocation() {
        return venueLocation;
    }
    
    /**
     * Sets the location for this {@code Venue}.
     * 
     * @param venueLocation venue location.
     * @see #getVenueLocation()
     */
    public void setVenueLocation(String venueLocation) {
        this.venueLocation = venueLocation;
    }
    
    /**
     * Gets the capacity of this {@code Venue}.
     * 
     * @return venue capacity.
     * @see #setVenueCapacity(Integer venueCapacity)
     */
    public Integer getVenueCapacity() {
        return venueCapacity;
    }
    
    /**
     * Sets the capacity for this {@code Venue}.
     * 
     * @param venueCapacity venue capacity.
     * @see #getVenueCapacity()
     */
    public void setVenueCapacity(Integer venueCapacity) {
        this.venueCapacity = venueCapacity;
    }
}
