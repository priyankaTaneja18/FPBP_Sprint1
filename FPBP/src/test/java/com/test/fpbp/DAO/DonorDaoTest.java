package com.test.fpbp.DAO;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fpbp.DAO.DonorDAO;
import com.fpbp.DAO.DonorDAOImpl;
import com.fpbp.model.Donor;
import com.test.fpbp.connection.ConnectionTest;

@RunWith(SpringJUnit4ClassRunner.class)
public class DonorDaoTest {

	
private DataSource dataSource;
    
    @Test
    public void testFetchProviders() {
    	
    	ConnectionTest ct = new ConnectionTest();
    	DataSource ds=ct.getSource();
        JdbcTemplate jt = new JdbcTemplate(ds);
        DonorDAO d=new DonorDAOImpl(ds,jt); 
		List<Donor> msg =  d.fetchProviders("Food");
		assertEquals(msg.size(),2);
		
        
    }
}
