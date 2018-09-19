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
		String sql = "insert into Seminars (VenueId, UserOrganiserId, UserHostId, SeminarTitle, SeminarDescription,"
				+ "SeminarDate, SeminarLastMins) valus (?,?,?,?,?,?,?);";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, seminar.getVenue().getVenueId());
		stmt.setString(2, seminar.getUserOrganiser().getUserId());
		stmt.setString(3, seminar.getUserHost().getUserId());
		stmt.setString(4, seminar.getSeminarTitle());
		stmt.setString(5, seminar.getSeminarDescription());
		stmt.setDate(6, seminar.getSeminarDate());
		stmt.setInt(7, seminar.getSeminarLastMins());
		int update = stmt.executeUpdate();
		if(update > 0)
			return true;
		else
			return false;
	}

	@Override
	public List<Seminar> findAll() throws SQLException {
		String sql = "select * from Seminars;";
		stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		Seminar seminar = null;
		List<Seminar> list = new ArrayList<Seminar>();
		while(rs.next()) {
			seminar = new Seminar();
			seminar.setSeminarId(rs.getInt("SeminarId"));
			seminar.setVenue(DAOFactory.getInstanceOfVenueDAO().findById(rs.getInt("VenueId")));
			seminar.setUserOrganiser(DAOFactory.getInstanceOfUserDAO().findById(rs.getString("UserOrganiserId")));
			seminar.setUserHost(DAOFactory.getInstanceOfUserDAO().findById(rs.getString("UserHostId")));
			seminar.setSeminarTitle(rs.getString("SeminarTitle"));
			seminar.setSeminarDescription(rs.getString("SeminarDescription"));
			seminar.setSeminarDate(rs.getDate("SeminarDate"));
			seminar.setSeminarLastMins(rs.getInt("SeminarLastMins"));
			list.add(seminar);
		}
		return list;
	}

	@Override
	public Seminar findById(int seminarId) throws SQLException {
		String sql = "select * from Seminars where SeminarId = ?;";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, seminarId);
		ResultSet rs = stmt.executeQuery();
		Seminar seminar = null;
		if(rs.next()) {
			seminar = new Seminar();
			seminar.setSeminarId(rs.getInt("SeminarId"));
			seminar.setVenue(DAOFactory.getInstanceOfVenueDAO().findById(rs.getInt("VenueId")));
			seminar.setUserOrganiser(DAOFactory.getInstanceOfUserDAO().findById(rs.getString("UserOrganiserId")));
			seminar.setUserHost(DAOFactory.getInstanceOfUserDAO().findById(rs.getString("UserHostId")));
			seminar.setSeminarTitle(rs.getString("SeminarTitle"));
			seminar.setSeminarDescription(rs.getString("SeminarDescription"));
			seminar.setSeminarDate(rs.getDate("SeminarDate"));
			seminar.setSeminarLastMins(rs.getInt("SeminarLastMins"));
		}
		return seminar;
	}
}
