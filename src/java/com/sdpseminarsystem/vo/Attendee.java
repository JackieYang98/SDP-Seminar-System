package com.sdpseminarsystem.vo;

import java.io.Serializable;

public class Attendee implements Serializable {
	
	private static final long serialVersionUID = -350294326949380782L;
	
	private Integer attendeeId;
	private String attendeeEmail;
	private String attendeePhone;
	private String attendeeFirstName;
	private String attendeeLastName;
	private Character attendeeState;
	
	public Integer getAttendeeId() {
		return attendeeId;
	}
	public void setAttendeeId(Integer attendeeId) {
		this.attendeeId = attendeeId;
	}
	public String getAttendeeEmail() {
		return attendeeEmail;
	}
	public void setAttendeeEmail(String attendeeEmail) {
		this.attendeeEmail = attendeeEmail;
	}
	public String getAttendeePhone() {
		return attendeePhone;
	}
	public void setAttendeePhone(String attendeePhone) {
		this.attendeePhone = attendeePhone;
	}
	public String getAttendeeFirstName() {
		return attendeeFirstName;
	}
	public void setAttendeeFirstName(String attendeeFirstName) {
		this.attendeeFirstName = attendeeFirstName;
	}
	public String getAttendeeLastName() {
		return attendeeLastName;
	}
	public void setAttendeeLastName(String attendeeLastName) {
		this.attendeeLastName = attendeeLastName;
	}
	public Character getAttendeeState() {
		return attendeeState;
	}
	public void setAttendeeState(Character attendeeState) {
		this.attendeeState = attendeeState;
	}
}
