package com.sdpseminarsystem.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.sdpseminarsystem.dao.ISeminarDAO;
import com.sdpseminarsystem.vo.Seminar;

public class SeminarDAOProxy extends DAOProxy implements ISeminarDAO {
	
	private ISeminarDAO dao;
	
	public SeminarDAOProxy() throws ClassNotFoundException, SQLException {
		dao = new SeminarDAOImpl(dbc.getConnection());
	}
	
	@Override
	public boolean create(Seminar seminar) throws SQLException {
		boolean flag = dao.create(seminar);
		dbc.close();
		return flag;
	}

	@Override
	public List<Seminar> findAll() throws SQLException {
		List<Seminar>list = dao.findAll();
		dbc.close();
		return list;
	}

	@Override
	public Seminar findById(int seminarId) throws SQLException {
		Seminar Seminar = dao.findById(seminarId);
		dbc.close();
		return Seminar;
	}
}
