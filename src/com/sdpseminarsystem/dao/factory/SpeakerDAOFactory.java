package com.sdpseminarsystem.dao.factory;

import java.sql.SQLException;

import com.sdpseminarsystem.dao.ISpeakerDAO;
import com.sdpseminarsystem.dao.impl.SpeakerDAOProxy;

public class SpeakerDAOFactory {
	public static ISpeakerDAO getInstance() {
		ISpeakerDAO dao = null;
		try {
			dao = new SpeakerDAOProxy();
		} catch (SQLException e) {
			// TODO auto-generated catch block
			e.printStackTrace();
		}
		return dao;
	}
}
