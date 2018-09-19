package com.sdpseminarsystem.vo;

import java.io.Serializable;

public class Venue implements Serializable {
	
	private static final long serialVersionUID = -5067450996883025696L;
	
	private int venueId;
	private String venueName;
	private String venueLocation;
	private int venueCapacity;
	
	public int getVenueId() {
		return venueId;
	}
	public void setVenueId(int venueId) {
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
	public int getVenueCapacity() {
		return venueCapacity;
	}
	public void setVenueCapacity(int venueCapacity) {
		this.venueCapacity = venueCapacity;
	}
}
