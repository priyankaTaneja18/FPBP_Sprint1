package com.test.fpbp.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fpbp.DAO.AdminViewDAO;
import com.fpbp.model.Donor;
import com.fpbp.model.Seeker;
import com.fpbp.service.AdminViewService;
import com.fpbp.service.IAdminViewService;
import com.fpbp.service.IUserService;
import com.fpbp.service.UserService;

public class AdminViewServiceTest {

	@Test
	public void testFindSeekers() {
		
		AdminViewDAO adminViewDAO= mock(AdminViewDAO.class);    
		List<Seeker> ls=new ArrayList<Seeker>();
		ls.add(new Seeker("UNCCOrg","Charlotte","980980","uncc.com","uncc@uncc.edu","Food",50,"Food",1));
		
	        //Given
	        given(adminViewDAO.findSeekers()).willReturn(ls);
	        //When
	        IAdminViewService avs= new AdminViewService(adminViewDAO);
	        List<Seeker> data= avs.findSeekers();
	        //Then
	        assertEquals("UNCCOrg",data.get(0).getOrgName());
	        assertEquals(1,data.size());
	       
	}

	@Test
	public void testFindDonors() {
		
		AdminViewDAO adminViewDAO= mock(AdminViewDAO.class);    
		List<Donor> ls=new ArrayList<Donor>();
		ls.add(new Donor("UNCC","Charlotte","980980","uncc@uncc.edu","5days","uncc.com","Education",1));
		
	        //Given
	        given(adminViewDAO.findDonor()).willReturn(ls);
	        //When
	        IAdminViewService avs= new AdminViewService(adminViewDAO);
	        List<Donor> data= avs.findDonor();
	        //Then
	        assertEquals("UNCC",data.get(0).getName());
	        assertEquals(1,data.size());
	       
	}

	@Test
	public void testDeleteSeekers() {
		
		AdminViewDAO adminViewDAO= mock(AdminViewDAO.class);    
		List<Donor> ls=new ArrayList<Donor>();
		ls.add(new Donor("UNCC","Charlotte","980980","uncc@uncc.edu","5days","uncc.com","Education",1));
		
	        //Given
	        given(adminViewDAO.deleteSeekers(1, "helpProvider")).willReturn(true);
	        //When
	        IAdminViewService avs= new AdminViewService(adminViewDAO);
	        boolean data= avs.deleteSeekers(1,"helpProvider" );
	        //Then
	        assertEquals(true,data);
	}
	
	
}
