package com.sdpseminarsystem.vo;

import java.io.Serializable;

public class Speaker implements Serializable {
	
	private static final long serialVersionUID = 8137883080259761342L;
	
	private Integer speakerId;
	private String speakerName;
	private String speakerBiography;
	
	public Integer getSpeakerId() {
		return speakerId;
	}
	public void setSpeakerId(Integer speakerId) {
		this.speakerId = speakerId;
	}
	public String getSpeakerName() {
		return speakerName;
	}
	public void setSpeakerName(String speakerName) {
		this.speakerName = speakerName;
	}
	public String getSpeakerBiography() {
		return speakerBiography;
	}
	public void setSpeakerBiography(String speakerBiography) {
		this.speakerBiography = speakerBiography;
	}
}
