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
        jt.update("delete from fpbpTest.fpbpUsers");
        jt.update("Insert into fpbpTest.fpbpUsers(email,password) values('user@test.com','test1234')");
		try {
			msg = d.validateUser("user@test.com", "test1234");
		} catch (SQLException e) {
			e.printStackTrace();
		}
        assertEquals(msg,"Login Successful");
        jt.update("delete from fpbpTest.fpbpUsers");
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
        jt.update("delete from fpbpTest.fpbpUsers");
       
		try {
			
			msg2 = d.registerUser("try@test.com", "test1234");
		} catch (SQLException e) {
			e.printStackTrace();
		}
     
        assertEquals(msg2,"Account created successfully");
        //assertEquals(categories.get(0),"Clothing");
        String sql = "SELECT count(email) FROM fpbpUsers where email=? ";

		//int result = getJdbcTemplate().queryForObject(sql, new Object[] {email});
		int result = jt.queryForObject(sql, Integer.class,new Object[] {"try@test.com"});
		assertEquals(result, 1);
		jt.update("delete from fpbpTest.fpbpUsers");
        
    }
    
    
    @Test
    public void RegisterUserTest_InValid() {
    	String msg= null;
    	String msg2 =null;
    	ConnectionTest ct = new ConnectionTest();
    	DataSource ds=ct.getSource();
        JdbcTemplate jt = new JdbcTemplate(ds);
        UserDAO d=new UserDAOImpl(ds,jt); 
        jt.update("delete from fpbpTest.fpbpUsers");
        jt.update("Insert into fpbpTest.fpbpUsers(email,password) values('user@test.com','test1234')");
		
		try {
			msg = d.registerUser("user@test.com", "test1234");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
        assertEquals(msg,"Email id already exists");
       
		jt.update("delete from fpbpTest.fpbpUsers");
        
    }
}