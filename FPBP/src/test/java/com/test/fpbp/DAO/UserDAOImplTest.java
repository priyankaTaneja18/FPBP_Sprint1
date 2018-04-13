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
			msg = d.validateUser("user@test.com", "test1234");
		} catch (SQLException e) {
			e.printStackTrace();
		}
        assertEquals(msg,"Login Successful");
        //assertEquals(categories.get(0),"Clothing");
        
    }
}