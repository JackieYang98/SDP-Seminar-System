package com.sdpseminarsystem.dao.factory;

import com.sdpseminarsystem.dao.*;

public class DAOFactory {
	
	public static IUserDAO getInstanceOfUserDAO() {
		return UserDAOFactory.getInstance();
	}
	
	public static IVenueDAO getInstanceOfVenueDAO() {
		return VenueDAOFactory.getInstance();
	}
	
	public static ISeminarDAO getInstanceOfSeminarDAO() {
		return SeminarDAOFactory.getInstance();
	}
	
	public static IAttendeeDAO getInstanceOfAttendeeDAO() {
		return AttendeeDAOFactory.getInstance();
	}
	
	public static ISpeakerDAO getInstanceOfSpeakerDAO() {
		return SpeakerDAOFactory.getInstance();
	}
}
