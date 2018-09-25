package com.sdpseminarsystem.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.sdpseminarsystem.dao.IAttendeeDAO;
import com.sdpseminarsystem.vo.Attendee;

public class AttendeeDAOProxy extends DAOProxy implements IAttendeeDAO {
	
	private IAttendeeDAO dao;
	
	public AttendeeDAOProxy() throws SQLException {
		dao = new AttendeeDAOImpl(dbc.getConnection());
	}

	@Override
	public boolean create(Attendee attendee, int seminarId) throws SQLException {
		boolean flag = dao.create(attendee, seminarId);
		dbc.close();
		return flag;
	}

	@Override
	public List<Attendee> findAllBySeminar(int seminarId) throws SQLException {
		List<Attendee>list = dao.findAllBySeminar(seminarId);
		dbc.close();
		return list;
	}

	@Override
	public Attendee findById(int attendeeId) throws SQLException {
		Attendee attendee = dao.findById(attendeeId);
		dbc.close();
		return attendee;
	}
}
