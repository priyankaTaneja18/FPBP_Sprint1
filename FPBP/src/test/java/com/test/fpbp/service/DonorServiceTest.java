package com.test.fpbp.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
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


public class DonorServiceTest {
	
	@Test
	public void testFetchProviders() {
		List<Donor> ls=new ArrayList<Donor>();
		ls.add(new Donor("UNCC","Charlotte","980980","uncc@uncc.edu","5days","uncc.com","Education",1));
		DonorDAO s= mock(DonorDAO.class);	
		//Given
		given(s.fetchProviders("Education")).willReturn(ls);
		//When
		IDonorService st= new DonorService(s);
		List<Donor> data= st.fetchProviders("Education");
		//Then
		
		assertThat(data.size(), is(1));
		assertEquals(data.get(0).getName(),"UNCC");
		}
	
	
	@Test
	public void testFetchProvidersBasedOnSearch() {
		List<Donor> ls=new ArrayList<Donor>();
		ls.add(new Donor("UNCC","Charlotte","980980","uncc@uncc.edu","5days","uncc.com","Education",1));
		DonorDAO s= mock(DonorDAO.class);	
		//Given
		given(s.fetchProvidersBasedOnSearch("Education","Charlotte")).willReturn(ls);
		//When
		IDonorService st= new DonorService(s);
		List<Donor> data= st.fetchProvidersBasedOnSearch("Education","Charlotte");
		//Then
		
		assertThat(data.size(), is(1));
		assertEquals(data.get(0).getName(),"UNCC");
		}
	
	
	@Test
	public void testFetchProvidersBasedOnSearchInvalid() {
		List<Donor> ls=new ArrayList<Donor>();
	
		DonorDAO s= mock(DonorDAO.class);	
		//Given
		given(s.fetchProvidersBasedOnSearch("Education","Charlotte")).willReturn(ls);
		//When
		IDonorService st= new DonorService(s);
		List<Donor> data= st.fetchProvidersBasedOnSearch("Education","Charlotte");
		//Then
		
		assertThat(data.size(), is(0));
		//assertEquals(data.get(0).getName(),"UNCC");
		}
	
	
	@Test
	public void testAddProvider() {
		
		Donor donor=new Donor("UNCC","Charlotte","980980","uncc@uncc.edu","5days","uncc.com","Education",1);
		DonorDAO s= mock(DonorDAO.class);	
		//Given
		given(s.addProvider(donor)).willReturn(true);
		//When
		IDonorService st= new DonorService(s);
		boolean data= st.addProvider(donor);
		//Then
		
		assertTrue(data);
		
		}
	
	@Test
	public void testAddProviderInvalid() {
		
		Donor donor=new Donor("UNCC","Charlotte","980980","uncc@uncc.edu","5days","uncc.com","Education",1);
		DonorDAO s= mock(DonorDAO.class);	
		//Given
		given(s.addProvider(donor)).willReturn(false);
		//When
		IDonorService st= new DonorService(s);
		boolean data= st.addProvider(donor);
		//Then
		
		assertFalse(data);
		
		}
	
}
