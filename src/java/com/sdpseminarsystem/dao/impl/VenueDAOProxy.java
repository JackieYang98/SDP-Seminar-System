  package com.sdpseminarsystem.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.sdpseminarsystem.dao.IVenueDAO;
import com.sdpseminarsystem.dbc.DatabaseConnector;
import com.sdpseminarsystem.vo.Venue;

public class VenueDAOProxy implements IVenueDAO {
	
	private DatabaseConnector dbc;
	private IVenueDAO dao;
	
	public VenueDAOProxy() throws ClassNotFoundException, SQLException {
		dbc = new DatabaseConnector();
		dao = new VenueDAOImpl(dbc.getConnection());
	}
	
	@Override
	public List<Venue> findAll() throws SQLException {
		List<Venue>list = dao.findAll();
		dbc.close();
		return list;
	}

	@Override
	public Venue findById(int venueId) throws SQLException {
		Venue venue = dao.findById(venueId);
		dbc.close();
		return venue;
	}

}
