package com.test.fpbp.DAO;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fpbp.DAO.SeekerDAO;
import com.fpbp.DAO.SeekerDAOImpl;
import com.fpbp.model.Seeker;
import com.test.fpbp.connection.ConnectionTest;

public class SeekerDaoTest {

	
	 @Test
	    public void testFetchSeekers() {
	    	
	    	ConnectionTest ct = new ConnectionTest();
	    	DataSource ds=ct.getSource();
	        JdbcTemplate jt = new JdbcTemplate(ds);
	        SeekerDAO d=new SeekerDAOImpl(ds,jt); 
			List<Seeker> msg =  d.fetchSeekers("Food");
			assertEquals(msg.size(),2);
			
	        
	    }
	 
	 @Test
	 public void testAddSeeker() {
		 
		 ConnectionTest ct = new ConnectionTest();
	    	DataSource ds=ct.getSource();
	        JdbcTemplate jt = new JdbcTemplate(ds);
	        
	        SeekerDAO d=new SeekerDAOImpl(ds,jt); 
	        Seeker s = new Seeker("PriTest","Charlotte","980980","uncc.com","uncc@uncc.edu","Food",50,"Food");
			boolean msg =  d.addSeeker(s);
			assertEquals(msg,true);
			jt.update("delete from fpbpTest.helpSeeker where org_name='PriTest'");
		 
	 }
}
