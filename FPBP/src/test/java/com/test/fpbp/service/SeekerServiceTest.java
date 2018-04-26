package com.test.fpbp.service;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fpbp.DAO.DonorDAO;
import com.fpbp.DAO.SeekerDAO;
import com.fpbp.model.Donor;
import com.fpbp.model.Seeker;
import com.fpbp.service.DonorService;
import com.fpbp.service.IDonorService;
import com.fpbp.service.ISeekerService;
import com.fpbp.service.SeekerService;
public class SeekerServiceTest {

		@Test
		public void testFetchSeekers() {
			List<Seeker> ls=new ArrayList<Seeker>();
			ls.add(new Seeker("UNCCOrg","Charlotte","980980","uncc.com","uncc@uncc.edu","Food",50,"Food",1));
			SeekerDAO s= mock(SeekerDAO.class);	
			//Given
			given(s.fetchSeekers("Food")).willReturn(ls);
			//When
			ISeekerService st= new SeekerService(s);
			List<Seeker> data= st.fetchSeekers("Food");
			//Then
			
			assertThat(data.size(), is(1));
			assertEquals(data.get(0).getOrgName(),"UNCCOrg");
			}
		
		@Test
		public void testAddSeeker() {
			
			Seeker seeker=new Seeker("UNCCOrg","Charlotte","980980","uncc.com","uncc@uncc.edu","Food",50,"Food",1);
			SeekerDAO s= mock(SeekerDAO.class);	
			//Given
			given(s.addSeeker(seeker)).willReturn(true);
			//When
			ISeekerService st= new SeekerService(s);
			boolean data= st.addSeeker(seeker);
			//Then
			
			assertTrue(data);
			
			}
		
		
		@Test
		public void testFetchSeekersBasedOnSearch() {
			List<Seeker> ls=new ArrayList<Seeker>();
			ls.add(new Seeker("UNCCOrg","Charlotte","980980","uncc.com","uncc@uncc.edu","Food",50,"Food",1));
			SeekerDAO s= mock(SeekerDAO.class);	
			//Given
			given(s.fetchSeekersBasedOnSearch("Food","Charlotte")).willReturn(ls);
			//When
			ISeekerService st= new SeekerService(s);
			List<Seeker> data= st.fetchSeekersBasedOnSearch("Food","Charlotte");
			//Then
			
			assertThat(data.size(), is(1));
			assertEquals(data.get(0).getOrgName(),"UNCCOrg");
			}
		
		
		
	}
	

	
