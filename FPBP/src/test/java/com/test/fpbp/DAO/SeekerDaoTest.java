package com.test.fpbp.DAO;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fpbp.DAO.DonorDAO;
import com.fpbp.DAO.DonorDAOImpl;
import com.fpbp.model.Donor;
import com.test.fpbp.connection.ConnectionTest;

public class SeekerDaoTest {

	
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
