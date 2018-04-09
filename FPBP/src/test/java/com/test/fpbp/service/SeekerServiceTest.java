package com.test.fpbp.service;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fpbp.DAO.SeekerDAO;
import com.fpbp.model.Seeker;
import com.fpbp.service.ISeekerService;
import com.fpbp.service.SeekerService;
public class SeekerServiceTest {

	@Test
	public void foodProvidersTest() {
		List<Seeker> ls=new ArrayList<Seeker>();
		ls.add(new Seeker("abc","9547 UTD","987-456-9876","abc@wer.com","9:00 AM- 5:00 PM"
				,"www.help.com"));	
		SeekerDAO s= mock(SeekerDAO.class);	
		//Given
		given(s.fetchProviders("Food")).willReturn(ls);
		//When
		ISeekerService st= new SeekerService(s);
		List<Seeker> data= st.fetchProviders("Food");
		//Then
		
		assertThat(data.size(), is(1));
	}
	

	
}
