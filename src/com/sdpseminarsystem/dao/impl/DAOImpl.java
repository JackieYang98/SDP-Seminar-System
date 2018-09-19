package com.sdpseminarsystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

public abstract class DAOImpl {

	protected Connection conn;
	protected PreparedStatement stmt = null;
	
	public DAOImpl(Connection conn) {
		this.conn = conn;
	} 
}
