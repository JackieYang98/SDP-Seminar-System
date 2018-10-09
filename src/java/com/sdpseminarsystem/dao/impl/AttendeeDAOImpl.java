package com.sdpseminarsystem.dao.impl;

import java.sql.*;
import java.util.*;

import com.sdpseminarsystem.dao.IAttendeeDAO;
import com.sdpseminarsystem.vo.Attendee;

/**
 * Implementation class of the DAO Attendee module.
 * 
 * @author Leo Lee
 * @since 1.0
 * @see com.sdpseminarsystem.vo.Attendee
 */
public class AttendeeDAOImpl extends DAOImpl implements IAttendeeDAO {
    
    public AttendeeDAOImpl(Connection conn) {
        super(conn);
    }
    
    @Override
    public boolean create(Attendee attendee, int seminarId) throws SQLException {
        String sql = "insert into attendees (SeminarId, AttendeeEmail, AttendeePhone, AttendeeFirstName,"
                + " AttendeeLastName, AttendeeState) values (?,?,?,?,?,?);";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, seminarId);
        stmt.setString(2, attendee.getAttendeeEmail());
        stmt.setString(3, attendee.getAttendeePhone());
        stmt.setString(4, attendee.getAttendeeFirstName());
        stmt.setString(5, attendee.getAttendeeLastName());
        stmt.setString(6, String.valueOf(attendee.getAttendeeState()));
        int update = stmt.executeUpdate();
        if (update > 0)
            return true;
        else
            return false;
    }
    
    @Override
    public List<Attendee> findAllBySeminar(int seminarId) throws SQLException {
        String sql = "select * from attendees where SeminarId = ?;";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, seminarId);
        ResultSet rs = stmt.executeQuery();
        return getAttendeeList(rs);
    }
    
    @Override
    public Attendee findById(int attendeeId) throws SQLException {
        String sql = "select * from attendees where AttendeeId = ?;";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, attendeeId);
        ResultSet rs = stmt.executeQuery();
        return getAttendee(rs);
    }
    
    @Override
    public Attendee findBySeminarAndEmail(int seminarId, String attendeeEmail) throws SQLException {
        String sql = "select * from attendees where SeminarId = ? and AttendeeEmail = ?;";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, seminarId);
        stmt.setString(2, attendeeEmail);
        ResultSet rs = stmt.executeQuery();
        return getAttendee(rs);
    }
    
    @Override
    public boolean update(Attendee attendee) throws SQLException {
        String sql = "update attendees set AttendeeEmail = ?, AttendeePhone = ?, AttendeeFirstName = ?,"
                + " AttendeeLastName = ?, AttendeeState = ? where AttendeeId = ?;";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, attendee.getAttendeeEmail());
        stmt.setString(2, attendee.getAttendeePhone());
        stmt.setString(3, attendee.getAttendeeFirstName());
        stmt.setString(4, attendee.getAttendeeLastName());
        stmt.setString(5, String.valueOf(attendee.getAttendeeState()));
        stmt.setInt(6, attendee.getAttendeeId());
        int update = stmt.executeUpdate();
        if (update > 0)
            return true;
        else
            return false;
    }
    
    @Override
    public boolean delete(Attendee attendee) throws SQLException {
        String sql = "delete from attendees where AttendeeId = ?;";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, attendee.getAttendeeId());
        int update = stmt.executeUpdate();
        if (update > 0)
            return true;
        else
            return false;
    }
    
    private List<Attendee> getAttendeeList(ResultSet rs) throws SQLException {
        List<Attendee> list = new ArrayList<Attendee>();
        while (rs.next()) {
            Attendee attendee = new Attendee();
            attendee.setAttendeeId(rs.getInt("AttendeeId"));
            attendee.setAttendeeEmail(rs.getString("AttendeeEmail"));
            attendee.setAttendeePhone(rs.getString("AttendeePhone"));
            attendee.setAttendeeFirstName(rs.getString("AttendeeFirstName"));
            attendee.setAttendeeLastName(rs.getString("AttendeeLastName"));
            attendee.setAttendeeState(rs.getString("AttendeeState").charAt(0));
            list.add(attendee);
        }
        return list;
    }
    
    private Attendee getAttendee(ResultSet rs) throws SQLException {
        List<Attendee> list = getAttendeeList(rs);
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }
}
