package com.fpbp.DAO;

import java.sql.SQLException;

import com.fpbp.model.Users;

public interface UserDAO {
	public String validateUser(String username, String password) throws SQLException;
	public String registerUser(String username, String password) throws SQLException;

}
