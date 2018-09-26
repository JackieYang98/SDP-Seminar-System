package com.sdpseminarsystem.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.sdpseminarsystem.dao.ISpeakerDAO;
import com.sdpseminarsystem.vo.Speaker;

public class SpeakerDAOProxy extends DAOProxy implements ISpeakerDAO {
	
	private ISpeakerDAO dao;
	
	public SpeakerDAOProxy() throws SQLException {
		dao = new SpeakerDAOImpl(dbc.getConnection());
	}

	@Override
	public boolean create(Speaker speaker, int seminarId) throws SQLException {
		boolean flag = dao.create(speaker, seminarId);
		dbc.close();
		return flag;
	}

	@Override
	public List<Speaker> findAllBySeminar(int seminarId) throws SQLException {
		List<Speaker>list = dao.findAllBySeminar(seminarId);
		dbc.close();
		return list;
	}

	@Override
	public Speaker findById(int speakerId) throws SQLException {
		Speaker speaker = dao.findById(speakerId);
		dbc.close();
		return speaker;
	}

	@Override
	public boolean update(Speaker speaker) throws SQLException {
		boolean flag = false;
		if(dao.findById(speaker.getSpeakerId()) != null)
			dao.update(speaker);
		dbc.close();
		return flag;
	}

	@Override
	public boolean delete(Speaker speaker) throws SQLException {
		boolean flag = false;
		if(dao.findById(speaker.getSpeakerId()) != null)
			dao.delete(speaker);
		dbc.close();
		return flag;
	}
}
