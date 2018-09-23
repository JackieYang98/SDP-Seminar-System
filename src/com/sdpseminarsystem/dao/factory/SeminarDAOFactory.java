package com.sdpseminarsystem.dao.factory;

import java.sql.SQLException;

import com.sdpseminarsystem.dao.ISeminarDAO;
import com.sdpseminarsystem.dao.impl.SeminarDAOProxy;

public class SeminarDAOFactory {
	public static ISeminarDAO getInstance() {
		ISeminarDAO dao = null;
		try {
			dao = new SeminarDAOProxy();
		} catch (SQLException e) {
			// TODO auto-generated catch block
			e.printStackTrace();
		}
		return dao;
	}
}
