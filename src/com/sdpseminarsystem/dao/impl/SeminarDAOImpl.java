package com.sdpseminarsystem.dao.impl;

import java.sql.*;
import java.util.*;

import com.sdpseminarsystem.dao.ISeminarDAO;
import com.sdpseminarsystem.dao.factory.DAOFactory;
import com.sdpseminarsystem.vo.Seminar;

public class SeminarDAOImpl extends DAOImpl implements ISeminarDAO {

	public SeminarDAOImpl(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Seminar seminar) throws SQLException {
		String sql = "insert into seminars (UserOrganiserId, VenueId, SeminarTitle, SeminarDescription,"
				+ "SeminarDate, SeminarLastMins) values (?,?,?,?,?,?);";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, seminar.getUserOrganiser().getUserId());
		stmt.setInt(2, seminar.getVenue().getVenueId());
		stmt.setString(3, seminar.getSeminarTitle());
		stmt.setString(4, seminar.getSeminarDescription());
		stmt.setTimestamp(5, new java.sql.Timestamp(seminar.getSeminarDate().getTime()));
		stmt.setInt(6, seminar.getSeminarLastMins());
		int update = stmt.executeUpdate();
		if(update > 0)
			return true;
		else
			return false;
	}

	@Override
	public List<Seminar> findAll() throws SQLException {
		String sql = "select * from seminars inner join venues where seminars.VenueId = venues.VenueId;";
		stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		Seminar seminar = null;
		List<Seminar> list = new ArrayList<Seminar>();
		while(rs.next()) {
			seminar = new Seminar();
			seminar.setSeminarId(rs.getInt("SeminarId"));
			seminar.setVenue(DAOFactory.getInstanceOfVenueDAO().findById(rs.getInt("seminars.VenueId")));
			seminar.setUserOrganiser(DAOFactory.getInstanceOfUserDAO().findById(rs.getString("UserOrganiserId")));
			seminar.setUserHost(DAOFactory.getInstanceOfUserDAO().findById(rs.getString("UserHostId")));
			seminar.setSeminarTitle(rs.getString("SeminarTitle"));
			seminar.setSeminarDescription(rs.getString("SeminarDescription"));
			seminar.setSeminarDate(new java.util.Date(rs.getTimestamp("SeminarDate").getTime()));
			seminar.setSeminarLastMins(rs.getInt("SeminarLastMins"));
			list.add(seminar);
		}
		return list;
	}

	@Override
	public Seminar findById(int seminarId) throws SQLException {
		String sql = "select * from seminars where SeminarId = ?;";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, seminarId);
		ResultSet rs = stmt.executeQuery();
		Seminar seminar = null;
		if(rs.next()) {
			seminar = new Seminar();
			seminar.setSeminarId(rs.getInt("SeminarId"));
			seminar.setVenue(DAOFactory.getInstanceOfVenueDAO().findById(rs.getInt("seminars.VenueId")));
			seminar.setUserOrganiser(DAOFactory.getInstanceOfUserDAO().findById(rs.getString("UserOrganiserId")));
			seminar.setUserHost(DAOFactory.getInstanceOfUserDAO().findById(rs.getString("UserHostId")));
			seminar.setSeminarTitle(rs.getString("SeminarTitle"));
			seminar.setSeminarDescription(rs.getString("SeminarDescription"));
			seminar.setSeminarDate(new java.util.Date(rs.getTimestamp("SeminarDate").getTime()));
			seminar.setSeminarLastMins(rs.getInt("SeminarLastMins"));
		}
		return seminar;
	}
}
