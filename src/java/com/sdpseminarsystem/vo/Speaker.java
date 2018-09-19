package com.sdpseminarsystem.vo;

import java.io.Serializable;

public class Speaker implements Serializable {
	
	private static final long serialVersionUID = 5283126160743378401L;
	
	private int speakerId;
	private Seminar seminar;
	private String speakerBiographyAddr;
	
	public int getSpeakerId() {
		return speakerId;
	}
	public void setSpeakerId(int speakerId) {
		this.speakerId = speakerId;
	}
	public Seminar getSeminar() {
		return seminar;
	}
	public void setSeminar(Seminar seminar) {
		this.seminar = seminar;
	}
	public String getSpeakerBiographyAddr() {
		return speakerBiographyAddr;
	}
	public void setSpeakerBiographyAddr(String speakerBiographyAddr) {
		this.speakerBiographyAddr = speakerBiographyAddr;
	}
}
