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
	public void CategoriesTest() {
		List<String> ls=new ArrayList<String>();
		ls.add(new String("Food"));	
		AvailableCategoriesDAO s= mock(AvailableCategoriesDAO.class);	
		//Given
		given(s.findCategories()).willReturn(ls);
		//When
		IAvailableCategoriesService st= new AvailableCategoriesService(s);
		List<String> data= st.findCategories();
		//Then
		
		assertThat(data.size(), is(1));
	}
	

	
}
