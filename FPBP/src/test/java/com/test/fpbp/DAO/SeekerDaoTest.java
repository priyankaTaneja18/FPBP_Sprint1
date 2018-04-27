package com.test.fpbp.DAO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
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
            jt.update("delete from fpbpTest.helpSeeker");
            jt.update("Insert into fpbpTest.helpSeeker(org_name,address,contact_no,website,email,requirement, quantity,Category) values('UNCC','Charlotte','980980','uncc.com','uncc@c.com','Rice',50,'Food')");
            jt.update("Insert into fpbpTest.helpSeeker(org_name,address,contact_no,website,email,requirement, quantity,Category) values('UNCCOrg','Charlotte','980980','uncc.com','uncc@c.com','Food',50,'Food')");
            List<Seeker> msg =  d.fetchSeekers("Food");
            assertEquals(msg.size(),2);
            jt.update("delete from fpbpTest.helpSeeker");
            
            
        }
     
     @Test
     public void testAddSeeker() {
         
         ConnectionTest ct = new ConnectionTest();
            DataSource ds=ct.getSource();
            JdbcTemplate jt = new JdbcTemplate(ds);
            jt.update("delete from fpbpTest.helpSeeker");
            SeekerDAO d=new SeekerDAOImpl(ds,jt); 
            Seeker s = new Seeker("PriTest","Charlotte","980980","uncc.com","uncc@uncc.edu","Rice",50,"Food",2);
            boolean msg =  d.addSeeker(s);
            assertEquals(msg,true);
            jt.update("delete from fpbpTest.helpSeeker");
         
     }
     
     
     
     @Test
        public void fetchSeekersBasedOnSearch_ValidEntry() {
            
            ConnectionTest ct = new ConnectionTest();
            DataSource ds=ct.getSource();
            JdbcTemplate jt = new JdbcTemplate(ds);
            jt.update("delete from fpbpTest.helpSeeker");
            jt.update("Insert into fpbpTest.helpSeeker(org_name,address,contact_no,website,email,requirement, quantity,Category) values('UNCC','ABC Charlotte','980980','uncc.com','uncc@c.com','Rice',50,'Food')");
            SeekerDAO d=new SeekerDAOImpl(ds,jt); 
            List<Seeker> msg =  d.fetchSeekersBasedOnSearch("Food","ABC Charlotte");
            assertEquals(msg.size(),1);
            jt.update("delete from fpbpTest.helpSeeker");
            
        }
     
     @Test
        public void fetchSeekersBasedOnSearch_InValidEntry() {
            
            ConnectionTest ct = new ConnectionTest();
            DataSource ds=ct.getSource();
            JdbcTemplate jt = new JdbcTemplate(ds);
            jt.update("delete from fpbpTest.helpSeeker");
            jt.update("Insert into fpbpTest.helpSeeker(org_name,address,contact_no,website,email,requirement, quantity,Category) values('UNCC','ABC Charlotte','980980','uncc.com','uncc@c.com','Rice',50,'Food')");
            SeekerDAO d=new SeekerDAOImpl(ds,jt); 
            List<Seeker> msg =  d.fetchSeekersBasedOnSearch("Food","XYZ");
            assertEquals(msg.size(),0);
            jt.update("delete from fpbpTest.helpSeeker");
            
        }
}


	
	