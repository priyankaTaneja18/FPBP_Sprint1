package com.test.fpbp.DAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fpbp.DAO.AdminViewDAO;
import com.fpbp.DAO.AdminViewDAOImpl;
import com.fpbp.DAO.DonorDAO;
import com.fpbp.DAO.DonorDAOImpl;
import com.fpbp.DAO.SeekerDAO;
import com.fpbp.DAO.SeekerDAOImpl;
import com.fpbp.model.Donor;
import com.fpbp.model.Seeker;
import com.test.fpbp.connection.ConnectionTest;

public class AdminViewDAOTest {

	@Test
	public void testFindSeekers() {
		
		
		ConnectionTest ct = new ConnectionTest();
        DataSource ds=ct.getSource();
        JdbcTemplate jt = new JdbcTemplate(ds);
        AdminViewDAO d=new AdminViewDAOImpl(ds,jt); 
        jt.update("delete from fpbpTest.helpSeeker");
        jt.update("Insert into fpbpTest.helpSeeker(org_name,address,contact_no,website,email,requirement, quantity,Category) values('UNCC','Charlotte','980980','uncc.com','uncc@c.com','Rice',50,'Food')");
        jt.update("Insert into fpbpTest.helpSeeker(org_name,address,contact_no,website,email,requirement, quantity,Category) values('UNCCOrg','Charlotte','980980','uncc.com','uncc@c.com','Food',50,'Food')");
        List<Seeker> msg =  d.findSeekers();
        assertEquals(msg.size(),2);
        jt.update("delete from fpbpTest.helpSeeker");
	}

	@Test
	public void testDeleteSeekers() {
		ConnectionTest ct = new ConnectionTest();
        DataSource ds=ct.getSource();
        JdbcTemplate jt = new JdbcTemplate(ds);
        AdminViewDAO d=new AdminViewDAOImpl(ds,jt); 
        jt.update("delete from fpbpTest.helpSeeker");
        jt.update("Insert into fpbpTest.helpSeeker(pid,org_name,address,contact_no,website,email,requirement, quantity,Category) values(1,'UNCC','Charlotte','980980','uncc.com','uncc@c.com','Rice',50,'Food')");
        boolean msg = d.deleteSeekers(1, "helpSeeker");
        assertEquals(msg,true);
        List<Map<String, Object>> rows = jt.queryForList("select * from helpSeeker");
        System.out.println(rows);
        assertEquals(0,rows.size());  
	}
	
	@Test
	public void testDeleteProviders() {
		ConnectionTest ct = new ConnectionTest();
        DataSource ds=ct.getSource();
        JdbcTemplate jt = new JdbcTemplate(ds);
        AdminViewDAO d=new AdminViewDAOImpl(ds,jt); 
        jt.update("delete from fpbpTest.helpProvider");
        jt.update("Insert into fpbpTest.helpProvider(pid,name,address,contact,email,hours_of_operation,website,Category) values(1,'UNCC','Charlotte','980980','uncc@c.com','9:00AM-5:00PM','uncc.com','Food')");
         boolean msg = d.deleteSeekers(1, "helpProvider");
        assertEquals(msg,true);
        List<Map<String, Object>> rows = jt.queryForList("select * from helpProvider");
        System.out.println(rows);
        assertEquals(0,rows.size());  
	}
	
	@Test
	public void testDeleteSeekersInvalid() {
		ConnectionTest ct = new ConnectionTest();
        DataSource ds=ct.getSource();
        JdbcTemplate jt = new JdbcTemplate(ds);
        AdminViewDAO d=new AdminViewDAOImpl(ds,jt); 
        jt.update("delete from fpbpTest.helpSeeker");
        boolean msg = d.deleteSeekers(1, "helpSeeker");
        assertEquals(msg,false);
	}
	
	@Test
	public void testDeleteProvidersInvalid() {
		ConnectionTest ct = new ConnectionTest();
        DataSource ds=ct.getSource();
        JdbcTemplate jt = new JdbcTemplate(ds);
        AdminViewDAO d=new AdminViewDAOImpl(ds,jt); 
        jt.update("delete from fpbpTest.helpProvider");
        boolean msg = d.deleteSeekers(1, "helpProvider");
        assertEquals(msg,false);
	}
	
	@Test
	public void testFindDonorInvalid() {
		ConnectionTest ct = new ConnectionTest();
    	DataSource ds=ct.getSource();
        JdbcTemplate jt = new JdbcTemplate(ds);
        AdminViewDAO d=new AdminViewDAOImpl(ds,jt); 
        jt.update("delete from fpbpTest.helpProvider");
        jt.update("Insert into fpbpTest.helpProvider(name,address,contact,email,hours_of_operation,website,Category) values('UNCC','Charlotte','980980','uncc@c.com','9:00AM-5:00PM','uncc.com','Food')");
        jt.update("Insert into fpbpTest.helpProvider(name,address,contact,email,hours_of_operation,website,Category) values('UNCCOrg','Charlotte','980980','uncc@c.com','9:00AM-5:00PM','uncc.com','Food')");
	
		List<Donor> msg =  d.findDonor();
		assertEquals(2,msg.size());
		jt.update("delete from fpbpTest.helpProvider");
	
	}
	
}
