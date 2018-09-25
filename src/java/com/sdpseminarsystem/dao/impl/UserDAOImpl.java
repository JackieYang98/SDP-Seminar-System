package com.sdpseminarsystem.dao.impl;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;
import java.util.*;

import com.sdpseminarsystem.dao.IUserDAO;
import com.sdpseminarsystem.login.PasswordHash;
import com.sdpseminarsystem.vo.User;

public class UserDAOImpl extends DAOImpl implements IUserDAO {
	
	public UserDAOImpl(Connection conn) {
		super(conn);
	} 
	
	@Override
	public boolean create(User user) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException {
		String sql = "insert into users (UserId, UserFirstName, UserLastName, UserEmail, UserPasswordHashed, UserTypeFlag)"
				+ " values (?,?,?,?,?,?);";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, user.getUserId());
		stmt.setString(2, user.getUserFirstName());
		stmt.setString(3, user.getUserLastName());
		stmt.setString(4, user.getUserEmail());
		stmt.setString(5, PasswordHash.createHash(user.getUserPassword()));
		stmt.setString(6, String.valueOf(user.getUserTypeFlag()));
		int update = stmt.executeUpdate();
		if(update > 0)
			return true;
		else
			return false;
	}

	@Override
	public List<User> findAll() throws SQLException {
		String sql = "select * from users;";
		stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		User user = null;
		List<User> list = new ArrayList<User>();
		while(rs.next()) {
			user = new User();
			user.setUserId(rs.getString("UserId"));
			user.setUserFirstName(rs.getString("UserFirstName"));
			user.setUserLastName(rs.getString("UserLastName"));
			user.setUserEmail(rs.getString("UserEmail"));
			user.setUserTypeFlag(rs.getString("UserTypeFlag").charAt(0));
			list.add(user);
		}
		return list;
	}

	@Override
	public User findById(String userId) throws SQLException {
		String sql = "select * from users where UserId = ?;";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, userId);
		ResultSet rs = stmt.executeQuery();
		User user = null;
		if(rs.next()) {
			user = new User();
			user.setUserId(rs.getString("UserId"));
			user.setUserFirstName(rs.getString("UserFirstName"));
			user.setUserLastName(rs.getString("UserLastName"));
			user.setUserEmail(rs.getString("UserEmail"));
			user.setUserTypeFlag(rs.getString("UserTypeFlag").charAt(0));
		}
		return user;
	}

	@Override
	public boolean verify(User user) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException {
		String sql = "select UserPasswordHashed from users where UserId = ?;";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, user.getUserId());
		ResultSet rs = stmt.executeQuery();
		if(rs.next())
			return PasswordHash.validatePassword(user.getUserPassword(), rs.getString("UserPasswordHashed"));
		else
			return false;
	}
}
