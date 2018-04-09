package com.test.fpbp.service;

import static org.hamcrest.CoreMatchers.is;
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
	public void foodDonorTest() {
		List<Donor> ls=new ArrayList<Donor>();
		ls.add(new Donor("Pantry","9547 UTD","987-456-9876","www.org.com","abc@wer.com"
				,"",1));	
		DonorDAO s= mock(DonorDAO.class);	
		//Given
		given(s.fetchSeekers("Food")).willReturn(ls);
		//When
		IDonorService st= new DonorService(s);
		List<Donor> data= st.fetchSeekers("Food");
		//Then
		
		assertThat(data.size(), is(1));
	}
	
	

	
	
	
	
}
