package com.sdpseminarsystem.dao.impl;

import java.sql.*;
import java.util.*;

import com.sdpseminarsystem.dao.IVenueDAO;
import com.sdpseminarsystem.vo.Venue;

public class VenueDAOImpl extends DAOImpl implements IVenueDAO {
	
	public VenueDAOImpl(Connection conn) {
		super(conn);
	}
	
	@Override
	public List<Venue> findAll() throws SQLException {
		String sql = "select * from venues;";
		stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		Venue venue = null;
		List<Venue> list = new ArrayList<Venue>();
		while(rs.next()) {
			venue = new Venue();
			venue.setVenueId(rs.getInt("VenueId"));
			venue.setVenueName(rs.getString("VenueName"));
			venue.setVenueLocation(rs.getString("VenueLocation"));
			venue.setVenueCapacity(rs.getInt("VenueCapacity"));
			list.add(venue);
		}
		return list;
	}

	@Override
	public Venue findById(int venueId) throws SQLException {
		String sql = "select * from venues where VenueId = ?;";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, venueId);
		ResultSet rs = stmt.executeQuery();
		Venue venue = null;
		if(rs.next()) {
			venue = new Venue();
			venue.setVenueId(rs.getInt("VenueId"));
			venue.setVenueName(rs.getString("VenueName"));
			venue.setVenueLocation(rs.getString("VenueLocation"));
			venue.setVenueCapacity(rs.getInt("VenueCapacity"));
		}
		return venue;
	}
        
        @Override
        public List<Venue> findByUserHostId(int hostId) throws SQLException {
		String sql = "select * from venues where UserHostId = ?;";
		stmt = conn.prepareStatement(sql);
                stmt.setInt(1, hostId);
		ResultSet rs = stmt.executeQuery();
		Venue venue = null;
		List<Venue> list = new ArrayList<Venue>();
		while(rs.next()) {
			venue = new Venue();
			venue.setVenueId(rs.getInt("VenueId"));
			venue.setVenueName(rs.getString("VenueName"));
			venue.setVenueLocation(rs.getString("VenueLocation"));
			venue.setVenueCapacity(rs.getInt("VenueCapacity"));
			list.add(venue);
		}
		return list;
	}

}
