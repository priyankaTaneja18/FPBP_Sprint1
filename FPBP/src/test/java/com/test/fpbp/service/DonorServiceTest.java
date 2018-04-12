package com.test.fpbp.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fpbp.DAO.DonorDAO;
import com.fpbp.model.Donor;
import com.fpbp.service.DonorService;
import com.fpbp.service.IDonorService;


public class DonorServiceTest {
	
	@Test
	public void testFetchProviders() {
		List<Donor> ls=new ArrayList<Donor>();
		ls.add(new Donor("UNCC","Charlotte","980980","uncc@uncc.edu","5days","uncc.com","Education"));
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
	
}
