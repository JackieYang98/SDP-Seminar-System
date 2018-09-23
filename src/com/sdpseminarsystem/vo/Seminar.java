package com.sdpseminarsystem.vo;

import java.io.Serializable;
import java.util.Date;

public class Seminar implements Serializable {
	
	private static final long serialVersionUID = 4036335793236909777L;
	
	private Integer seminarId;
	private Venue venue;
	private User userOrganiser;
	private User userHost;
	private String seminarTitle;
	private String seminarDescription;
	private Date seminarDate;
	private Integer seminarLastMins;
	
	public Integer getSeminarId() {
		return seminarId;
	}
	public void setSeminarId(Integer seminarId) {
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
	public Integer getSeminarLastMins() {
		return seminarLastMins;
	}
	public void setSeminarLastMins(Integer seminarLastMins) {
		this.seminarLastMins = seminarLastMins;
	}
}
