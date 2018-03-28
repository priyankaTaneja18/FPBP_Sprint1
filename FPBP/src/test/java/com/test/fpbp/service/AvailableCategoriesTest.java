package com.test.fpbp.service;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fpbp.DAO.AvailableCategoriesDAO;
import com.fpbp.service.AvailableCategoriesService;
import com.fpbp.service.IAvailableCategoriesService;

public class AvailableCategoriesTest {
	

	@Test
	public void seekHelpCategoriesTest() {
		List<String> ls=new ArrayList<String>();
		ls.add(new String("Food"));	
		AvailableCategoriesDAO s= mock(AvailableCategoriesDAO.class);	
		//Given
		given(s.seekHelpCategories()).willReturn(ls);
		//When
		IAvailableCategoriesService st= new AvailableCategoriesService(s);
		List<String> data= st.seekHelpCategories();
		//Then
		
		assertThat(data.size(), is(1));
	}
	

	@Test
	public void donateHelpCategoriesTest() {
		List<String> ls=new ArrayList<String>();
		ls.add(new String("Clothing"));	
		AvailableCategoriesDAO s= mock(AvailableCategoriesDAO.class);	
		//Given
		given(s.donateHelpCategories()).willReturn(ls);
		//When
		IAvailableCategoriesService st= new AvailableCategoriesService(s);
		List<String> data= st.donateHelpCategories();
		//Then
		
		assertThat(data.size(), is(1));
	}
	
}
