package com.test.fpbp.DAO;
import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fpbp.DAO.UserDAO;
import com.fpbp.DAO.UserDAOImpl;
import com.test.fpbp.connection.ConnectionTest;


@RunWith(SpringJUnit4ClassRunner.class)
public class UserDAOImplTest   {
    private DataSource dataSource;
    
    @Test
    public void ValidateUserTest() {
    	String msg= null;
    	ConnectionTest ct = new ConnectionTest();
    	DataSource ds=ct.getSource();
        JdbcTemplate jt = new JdbcTemplate(ds);
        UserDAO d=new UserDAOImpl(ds,jt); 
		try {
			msg = d.validateUser("use22r@test.com", "test1234");
		} catch (SQLException e) {
			e.printStackTrace();
		}
        assertEquals(msg,"Login Successful");
        
        //assertEquals(categories.get(0),"Clothing");
        
    }
    
    @Test
    public void RegisterUserTest() {
    	String msg= null;
    	String msg2 =null;
    	ConnectionTest ct = new ConnectionTest();
    	DataSource ds=ct.getSource();
        JdbcTemplate jt = new JdbcTemplate(ds);
        UserDAO d=new UserDAOImpl(ds,jt); 
		try {
			msg = d.registerUser("user@test.com", "test1234");
			msg2 = d.registerUser("tryyhs@test.com", "test1234");
		} catch (SQLException e) {
			e.printStackTrace();
		}
        assertEquals(msg,"Email id already exists");
        assertEquals(msg2,"Account created successfully");
        //assertEquals(categories.get(0),"Clothing");
        String sql = "SELECT count(email) FROM fpbpUsers where email=? ";

		//int result = getJdbcTemplate().queryForObject(sql, new Object[] {email});
		int result = jt.queryForObject(sql, Integer.class,new Object[] {"abc@test.com"});
		assertEquals(result, 1);
        
    }
}