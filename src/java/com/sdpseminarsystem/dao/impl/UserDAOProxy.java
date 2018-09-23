package com.sdpseminarsystem.dao.impl;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.List;

import com.sdpseminarsystem.dao.IUserDAO;
import com.sdpseminarsystem.dbc.DatabaseConnector;
import com.sdpseminarsystem.vo.User;

public class UserDAOProxy implements IUserDAO {
	
	private DatabaseConnector dbc;
	private IUserDAO dao;
	
	public UserDAOProxy() throws ClassNotFoundException, SQLException {
		dbc = new DatabaseConnector();
		dao = new UserDAOImpl(dbc.getConnection());
	}
	
	@Override
	public boolean create(User user) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException {
		boolean flag = false;
		if(dao.findById(user.getUserId()) == null)
			flag = dao.create(user);
		dbc.close();
		return flag;
	}
	
	@Override
	public List<User> findAll() throws SQLException {
		List<User>list = dao.findAll();
		dbc.close();
		return list;
	}
	
	@Override
	public User findById(String userId) throws SQLException {
		User user = dao.findById(userId);
		dbc.close();
		return user;
	}
	
	@Override
	public boolean verify(User user) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException {
		boolean flag = false;
		if(dao.findById(user.getUserId()) != null)
			flag = true;
		return flag;
	}
}
