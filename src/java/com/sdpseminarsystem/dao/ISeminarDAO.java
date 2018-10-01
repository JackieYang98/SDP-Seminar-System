package com.sdpseminarsystem.dao;

import java.sql.SQLException;
import java.util.List;

import com.sdpseminarsystem.vo.*;

public interface ISeminarDAO {
	public int create(Seminar seminar) throws SQLException;
	public List<Seminar> findAll() throws SQLException;
	public List<Seminar> findAllSortByDate() throws SQLException;
	public List<Seminar> findAllSortByVenue() throws SQLException;
	public Seminar findById(int seminarId) throws SQLException;
	public List<Seminar> findByUser(User user) throws SQLException;
	public boolean update(Seminar seminar) throws SQLException;
	public boolean delete(Seminar seminar) throws SQLException;
}
