package com.sdpseminarsystem.dao;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.List;

import com.sdpseminarsystem.vo.User;

public interface IUserDAO {
	public boolean create(User user) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException;
	public List<User> findAll() throws SQLException;
	public User findById(String userId) throws SQLException;
	public boolean update(User user) throws SQLException;
	public boolean delete(User user) throws SQLException;
	public boolean verify(User user) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException;
}
