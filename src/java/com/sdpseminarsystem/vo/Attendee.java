package com.sdpseminarsystem.vo;

import java.io.Serializable;

public class Attendee implements Serializable {
	
	private static final long serialVersionUID = 8653613949704220660L;
	
	private int attendeeId;
	private Seminar Seminar;
	private String attendeeEmail;
	private String attendeeFirstName;
	private String attendeeLastName;
	private char attendeeState;
	
	public int getAttendeeId() {
		return attendeeId;
	}
	public void setAttendeeId(int attendeeId) {
		this.attendeeId = attendeeId;
	}
	public Seminar getSeminar() {
		return Seminar;
	}
	public void setSeminar(Seminar seminar) {
		Seminar = seminar;
	}
	public String getAttendeeEmail() {
		return attendeeEmail;
	}
	public void setAttendeeEmail(String attendeeEmail) {
		this.attendeeEmail = attendeeEmail;
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
	public char getAttendeeState() {
		return attendeeState;
	}
	public void setAttendeeState(char attendeeState) {
		this.attendeeState = attendeeState;
	}
}
