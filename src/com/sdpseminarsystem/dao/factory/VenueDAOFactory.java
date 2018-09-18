package com.sdpseminarsystem.dao.factory;

import java.sql.SQLException;

import com.sdpseminarsystem.dao.IVenueDAO;
import com.sdpseminarsystem.dao.impl.VenueDAOProxy;

public class VenueDAOFactory {
	public static IVenueDAO getInstance() {
		IVenueDAO dao = null;
		try {
			dao = new VenueDAOProxy();
		} catch (ClassNotFoundException e) {
			// TODO auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO auto-generated catch block
			e.printStackTrace();
		}
		return dao;
	}
}
