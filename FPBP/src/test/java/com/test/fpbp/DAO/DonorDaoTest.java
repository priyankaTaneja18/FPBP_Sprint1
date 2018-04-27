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
import com.fpbp.DAO.SeekerDAO;
import com.fpbp.DAO.SeekerDAOImpl;
import com.fpbp.model.Donor;
import com.fpbp.model.Seeker;
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
        jt.update("Insert into fpbpTest.helpProvider(name,address,contact,email,hours_of_operation,website,Category) values('UNCC','Charlotte','980980','uncc@c.com','9:00AM-5:00PM','uncc.com','Food')");
        jt.update("Insert into fpbpTest.helpProvider(name,address,contact,email,hours_of_operation,website,Category) values('UNCCOrg','Charlotte','980980','uncc@c.com','9:00AM-5:00PM','uncc.com','Food')");
	
		List<Donor> msg =  d.fetchProviders("Food");
		assertEquals(2,msg.size());
		jt.update("delete from fpbpTest.helpProvider");
		
        
    }
    
    
    
	 @Test
	    public void fetchDonorBasedOnSearch_ValidEntry() {
	    	
	    	ConnectionTest ct = new ConnectionTest();
	    	DataSource ds=ct.getSource();
	        JdbcTemplate jt = new JdbcTemplate(ds);
	        
	        jt.update("Insert into fpbpTest.helpProvider(name,address,contact,email,hours_of_operation,website,Category) values('UNCC','ABC Charlotte','980980','uncc@c.com','9:00AM-5:00PM','uncc.com','Food')");
	         DonorDAO d=new DonorDAOImpl(ds,jt); 
			List<Donor> msg =  d.fetchProvidersBasedOnSearch("Food","ABC Charlotte");
			assertEquals(msg.size(),1);
			jt.update("delete from fpbpTest.helpProvider where category='Food' and address='ABC Charlotte'");
	        
	    }
	 

	 @Test
	    public void fetchDonorBasedOnSearch_InValidEntry() {
	    	
	    	ConnectionTest ct = new ConnectionTest();
	    	DataSource ds=ct.getSource();
	        JdbcTemplate jt = new JdbcTemplate(ds);
	        
	        jt.update("Insert into fpbpTest.helpProvider(name,address,contact,email,hours_of_operation,website,Category) values('UNCC','ABC Charlotte','980980','uncc@c.com','9:00AM-5:00PM','uncc.com','Food')");
	         DonorDAO d=new DonorDAOImpl(ds,jt); 
			List<Donor> msg =  d.fetchProvidersBasedOnSearch("Food","XYZ");
			assertEquals(msg.size(),0);
			jt.update("delete from fpbpTest.helpProvider where category='Food' and address='ABC Charlotte'");
	        
	    }
	 
	 
	 

     @Test
     public void testAddProvider() {
         
         ConnectionTest ct = new ConnectionTest();
            DataSource ds=ct.getSource();
            JdbcTemplate jt = new JdbcTemplate(ds);
            
            DonorDAO d=new DonorDAOImpl(ds,jt); 
            jt.update("delete from fpbpTest.helpProvider");
            Donor s = new Donor("UNCC","Charlotte","980980","uncc@uncc.edu","5days","uncc.com","Education",1);
            boolean msg =  d.addProvider(s);
            assertEquals(msg,true);
            jt.update("delete from fpbpTest.helpProvider");
         
     }
}
