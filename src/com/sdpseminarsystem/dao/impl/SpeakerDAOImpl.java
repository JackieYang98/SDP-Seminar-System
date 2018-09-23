package com.sdpseminarsystem.dao.impl;

import java.sql.*;
import java.util.*;

import com.sdpseminarsystem.dao.ISpeakerDAO;
import com.sdpseminarsystem.vo.Speaker;

public class SpeakerDAOImpl extends DAOImpl implements ISpeakerDAO {

	public SpeakerDAOImpl(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Speaker speaker, int seminarId) throws SQLException {
		String sql = "insert into speakers (SeminarId, SpeakerName, SpeakerBiography) values (?,?,?,?,?,?);";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, seminarId);
		stmt.setString(2, speaker.getSpeakerName());
		stmt.setString(3, speaker.getSpeakerBiography());
		int update = stmt.executeUpdate();
		if(update > 0)
			return true;
		else
			return false;
	}

	@Override
	public List<Speaker> findAllBySeminar(int seminarId) throws SQLException {
		String sql = "select * from speakers where SeminarId = ?;";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, seminarId);
		ResultSet rs = stmt.executeQuery();
		Speaker speaker = null;
		List<Speaker> list = new ArrayList<Speaker>();
		while(rs.next()) {
			speaker = new Speaker();
			speaker.setSpeakerId(rs.getInt("SpeakerId"));
			speaker.setSpeakerName(rs.getString("SpeakerName"));
			speaker.setSpeakerBiography(rs.getString("SpeakerBiography"));
			list.add(speaker);
		}
		return list;
	}

	@Override
	public Speaker findById(int speakerId) throws SQLException {
		String sql = "select * from speakers where SpeakerId = ?;";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, speakerId);
		ResultSet rs = stmt.executeQuery();
		Speaker speaker = null;
		while(rs.next()) {
			speaker = new Speaker();
			speaker.setSpeakerId(rs.getInt("SpeakerId"));
			speaker.setSpeakerName(rs.getString("SpeakerName"));
			speaker.setSpeakerBiography(rs.getString("SpeakerBiography"));
		}
		return speaker;
	}
}
