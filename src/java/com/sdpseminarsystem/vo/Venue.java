package com.sdpseminarsystem.vo;

import java.io.Serializable;

public class Venue implements Serializable {
	
	private static final long serialVersionUID = -1510807057622218077L;
	
	private Integer venueId;
	private String venueName;
	private String venueLocation;
	private Integer venueCapacity;
	
	public Integer getVenueId() {
		return venueId;
	}
	public void setVenueId(Integer venueId) {
		this.venueId = venueId;
	}
	public String getVenueName() {
		return venueName;
	}
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	public String getVenueLocation() {
		return venueLocation;
	}
	public void setVenueLocation(String venueLocation) {
		this.venueLocation = venueLocation;
	}
	public Integer getVenueCapacity() {
		return venueCapacity;
	}
	public void setVenueCapacity(Integer venueCapacity) {
		this.venueCapacity = venueCapacity;
	}
}
