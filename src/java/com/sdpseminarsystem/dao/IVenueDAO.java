package com.sdpseminarsystem.dao;

import java.sql.SQLException;
import java.util.List;

import com.sdpseminarsystem.vo.Venue;

public interface IVenueDAO {
	public List<Venue> findAll() throws SQLException;
	public Venue findById(int venueId) throws SQLException;
        public List<Venue> findByUserHostId(int hostId) throws SQLException;
}
