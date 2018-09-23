package com.sdpseminarsystem.dao.factory;

import java.sql.SQLException;

import com.sdpseminarsystem.dao.IUserDAO;
import com.sdpseminarsystem.dao.impl.UserDAOProxy;

public class UserDAOFactory {
	public static IUserDAO getInstance() {
		IUserDAO dao = null;
		try {
			dao = new UserDAOProxy();
		} catch (SQLException e) {
			// TODO auto-generated catch block
			e.printStackTrace();
		}
		return dao;
	}
}
