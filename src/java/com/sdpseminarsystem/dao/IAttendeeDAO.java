package com.sdpseminarsystem.dao;

import java.sql.SQLException;
import java.util.List;

import com.sdpseminarsystem.vo.Attendee;

public interface IAttendeeDAO {
	public boolean create(Attendee attendee, int seminarId) throws SQLException;
	public List<Attendee> findAllBySeminar(int seminarId) throws SQLException;
	public Attendee findById(int attendeeId) throws SQLException;
	public Attendee findBySeminarAndEmail(int seminarId, String attendeeEmail) throws SQLException;
	public boolean update(Attendee attendee) throws SQLException;
	public boolean delete(Attendee attendee) throws SQLException;
}
