package com.sdpseminarsystem.dao;

import java.sql.SQLException;
import java.util.List;

import com.sdpseminarsystem.vo.Speaker;

public interface ISpeakerDAO {
	public boolean create(Speaker speaker, int seminarId) throws SQLException;
	public List<Speaker> findAllBySeminar(int seminarId) throws SQLException;
	public Speaker findById(int speakerId) throws SQLException;
}
