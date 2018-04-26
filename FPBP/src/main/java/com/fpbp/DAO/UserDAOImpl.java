package com.fpbp.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.fpbp.model.Users;

@Repository
public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {

	@Autowired 
	DataSource dataSource;	
	
	JdbcTemplate jdbcTemplate;
	

	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
		jdbcTemplate=new JdbcTemplate(dataSource);
	}

	
	public UserDAOImpl(DataSource dataSource, JdbcTemplate jdbcTemplate) {
		this.dataSource = dataSource;
		this.jdbcTemplate = jdbcTemplate;
	}



	public String validateUser(String email, String password) throws SQLException
	{	
		String msg= null;
		String sql = "select * from fpbpUsers where email = ?";
		//getJdbcTemplate().queryForInt()
		/*Users user = (User) getJdbcTemplate().queryForObject(sql, new Object[] {email}, new UserRowMapper());*/
		try {
			Users user = (Users)jdbcTemplate.queryForObject(
					sql, new Object[] { email }, new UserRowMapper());
			if(!user.getPassword().equals(password))
				msg="Invalid password";
			else
				msg="Login Successful";
		}
		catch (EmptyResultDataAccessException e) {
			msg="Invalid email";
			return msg;
		}
		return msg;
	}
	@SuppressWarnings("rawtypes")
	public class UserRowMapper implements RowMapper
	{
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Users user=null;
			if(rs!=null) {
				user = new Users();
				user.setPassword(rs.getString("password"));
				user.setEmailId(rs.getString("email"));
			}
			return user;
		}

	}

	public String registerUser(String email, String password) throws SQLException {
		// TODO Auto-generated method stub
		String msg=null;
		String sql = "SELECT count(email) FROM fpbpUsers where email=? ";

		//int result = getJdbcTemplate().queryForObject(sql, new Object[] {email});
		int result = jdbcTemplate.queryForObject(sql, Integer.class,new Object[] {email});

		if(result == 1)
		{
			msg="Email id already exists";
		}
		else {

			String sql1 = "Insert into fpbpUsers (email,password)"
					+ "values(?,?)";
			Object[] params = new Object[] {email,password };
			int[] types = new int[] { Types.VARCHAR, Types.VARCHAR};

			try {
				int row = jdbcTemplate.update(sql1, params, types);
				msg="Account created successfully";
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		return msg;
	}
}


