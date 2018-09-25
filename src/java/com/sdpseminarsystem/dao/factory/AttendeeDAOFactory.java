package com.sdpseminarsystem.dao.factory;

import java.sql.SQLException;

import com.sdpseminarsystem.dao.IAttendeeDAO;
import com.sdpseminarsystem.dao.impl.AttendeeDAOProxy;

public class AttendeeDAOFactory {
	public static IAttendeeDAO getInstance() {
		IAttendeeDAO dao = null;
		try {
			dao = new AttendeeDAOProxy();
		} catch (SQLException e) {
			// TODO auto-generated catch block
			e.printStackTrace();
		}
		return dao;
	}
}
