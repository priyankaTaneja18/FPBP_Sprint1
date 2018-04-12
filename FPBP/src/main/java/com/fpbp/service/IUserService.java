package com.fpbp.service;

import java.sql.SQLException;

public interface IUserService {
	public String validateUser(String username, String password) throws SQLException;

	public String registerUser(String emailId, String password) throws SQLException;

}
