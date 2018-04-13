package com.fpbp.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpbp.DAO.UserDAO;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserDAO userDao;
	
	public UserDAO getUserDao() {
		return this.userDao;
	}

	public void setUserDao(UserDAO userDao)  {
		this.userDao = userDao;
	}
	

	public UserService(UserDAO userDao) {
		super();
		this.userDao = userDao;
	}

	public String validateUser(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return userDao.validateUser(username, password);
	}

	public String registerUser(String emailId, String password) throws SQLException {
		// TODO Auto-generated method stub
		return userDao.registerUser(emailId, password);
	}



}
