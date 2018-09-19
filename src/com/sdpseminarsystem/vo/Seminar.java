package com.sdpseminarsystem.vo;

import java.io.Serializable;
import java.sql.Date;

public class Seminar implements Serializable {
	
	private static final long serialVersionUID = 3566639161383290634L;
	
	private int seminarId;
	private Venue venue;
	private User userOrganiser;
	private User userHost;
	private String seminarTitle;
	private String seminarDescription;
	private Date seminarDate;
	private int seminarLastMins;
	
	public int getSeminarId() {
		return seminarId;
	}
	public void setSeminarId(int seminarId) {
		this.seminarId = seminarId;
	}
	public Venue getVenue() {
		return venue;
	}
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	public User getUserOrganiser() {
		return userOrganiser;
	}
	public void setUserOrganiser(User userOrganiser) {
		this.userOrganiser = userOrganiser;
	}
	public User getUserHost() {
		return userHost;
	}
	public void setUserHost(User userHost) {
		this.userHost = userHost;
	}
	public String getSeminarTitle() {
		return seminarTitle;
	}
	public void setSeminarTitle(String seminarTitle) {
		this.seminarTitle = seminarTitle;
	}
	public String getSeminarDescription() {
		return seminarDescription;
	}
	public void setSeminarDescription(String seminarDescription) {
		this.seminarDescription = seminarDescription;
	}
	public Date getSeminarDate() {
		return seminarDate;
	}
	public void setSeminarDate(Date seminarDate) {
		this.seminarDate = seminarDate;
	}
	public int getSeminarLastMins() {
		return seminarLastMins;
	}
	public void setSeminarLastMins(int seminarLastMins) {
		this.seminarLastMins = seminarLastMins;
	}
}
