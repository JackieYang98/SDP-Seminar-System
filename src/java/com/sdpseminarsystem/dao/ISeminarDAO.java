package com.sdpseminarsystem.dao;

import java.sql.SQLException;
import java.util.List;

import com.sdpseminarsystem.vo.Seminar;

public interface ISeminarDAO {
	public boolean create(Seminar seminar) throws SQLException;
	public List<Seminar> findAll() throws SQLException;
	public Seminar findById(int seminarId) throws SQLException;
}
