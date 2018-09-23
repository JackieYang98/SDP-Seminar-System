package com.sdpseminarsystem.dao.impl;

import java.sql.SQLException;

import com.sdpseminarsystem.dbc.DatabaseConnector;

public abstract class DAOProxy {
	
	protected DatabaseConnector dbc;
	
	public DAOProxy() throws SQLException {
		dbc = new DatabaseConnector();
	}
}
