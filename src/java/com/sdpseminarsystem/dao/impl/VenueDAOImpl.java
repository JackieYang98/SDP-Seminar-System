package com.sdpseminarsystem.dao.impl;

import java.sql.*;
import java.util.*;

import com.sdpseminarsystem.dao.IVenueDAO;
import com.sdpseminarsystem.vo.Venue;

/**
 * Implementation class of the DAO Venue module.
 * 
 * @author Leo Lee
 * @since 1.0
 * @see com.sdpseminarsystem.vo.Venue
 */
public class VenueDAOImpl extends DAOImpl implements IVenueDAO {
    
    public VenueDAOImpl(Connection conn) {
        super(conn);
    }
    
    @Override
    public List<Venue> findAll() throws SQLException {
        String sql = "select * from venues;";
        stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        return getVenueList(rs);
    }
    
    @Override
    public Venue findById(int venueId) throws SQLException {
        String sql = "select * from venues where VenueId = ?;";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, venueId);
        ResultSet rs = stmt.executeQuery();
        return getVenue(rs);
    }
    
    @Override
    public List<Venue> findByUserHostId(int hostId) throws SQLException {
        String sql = "select * from venues where UserHostId = ?;";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, hostId);
        ResultSet rs = stmt.executeQuery();
        return getVenueList(rs);
    }
    
    private List<Venue> getVenueList(ResultSet rs) throws SQLException {
        List<Venue> list = new ArrayList<Venue>();
        while (rs.next()) {
            Venue venue = new Venue();
            venue.setVenueId(rs.getInt("VenueId"));
            venue.setVenueName(rs.getString("VenueName"));
            venue.setVenueLocation(rs.getString("VenueLocation"));
            venue.setVenueCapacity(rs.getInt("VenueCapacity"));
            list.add(venue);
        }
        return list;
    }
    
    private Venue getVenue(ResultSet rs) throws SQLException {
        List<Venue> list = getVenueList(rs);
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }
}
