package com.sdpseminarsystem.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.sdpseminarsystem.dao.ISeminarDAO;
import com.sdpseminarsystem.vo.*;

public class SeminarDAOProxy extends DAOProxy implements ISeminarDAO {

	private ISeminarDAO dao;

	public SeminarDAOProxy() throws SQLException {
		dao = new SeminarDAOImpl(dbc.getConnection());
	}

	@Override
	public int create(Seminar seminar) throws SQLException {
		int lastInsertId = dao.create(seminar);
		dbc.close();
		return lastInsertId;
	}

	@Override
	public List<Seminar> findAll() throws SQLException {
		List<Seminar>list = dao.findAll();
		dbc.close();
		return list;
	}

	@Override
	public List<Seminar> findAllSortByDate() throws SQLException {
		List<Seminar>list = dao.findAllSortByDate();
		dbc.close();
		return list;
	}

	@Override
	public List<Seminar> findAllSortByVenue() throws SQLException {
		List<Seminar>list = dao.findAllSortByVenue();
		dbc.close();
		return list;
	}

	@Override
	public Seminar findById(int seminarId) throws SQLException {
		Seminar Seminar = dao.findById(seminarId);
		dbc.close();
		return Seminar;
	}

	@Override
	public List<Seminar> findByUser(User user) throws SQLException {
		List<Seminar>list = dao.findByUser(user);
		dbc.close();
		return list;
	}

	@Override
	public boolean update(Seminar seminar) throws SQLException {
		boolean flag = false;
		if(dao.findById(seminar.getSeminarId()) != null)
			flag = dao.update(seminar);
		return flag;
	}

	@Override
	public boolean delete(Seminar seminar) throws SQLException {
		boolean flag = false;
		if(dao.findById(seminar.getSeminarId()) != null)
			flag = dao.delete(seminar);
		return flag;
	}
}
