package com.test.fpbp.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fpbp.controller.DonorController;
import com.fpbp.model.Donor;
import com.fpbp.service.DonorService;
import com.fpbp.service.IDonorService;

public class DonorControllerTest {
	
	

	private MockMvc mockMvc;
	private DonorController ac;
		
	
	@Test
	public void testFetchProviders() {
		List<Donor> ls=new ArrayList<Donor>();
		ls.add(new Donor("UNCC","Charlotte","980980","uncc@uncc.edu","5days","uncc.com","Education",1));
		
		ac = new DonorController();
				
		IDonorService av=mock(DonorService.class);
		ac.setDonorService(av);
		mockMvc = MockMvcBuilders.standaloneSetup(ac).build();
		when(av.fetchProviders("Education")).thenReturn(ls);
		
		//When		
		try {
			  mockMvc.perform(get("/AvailableCategories/Providers").param("category", "Education"))
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
					.andExpect(jsonPath("$", hasSize(1)))
					.andExpect(jsonPath("$[0].name", is("UNCC")));
					;
					
					
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	@Test
	public void testFetchProvidersBasedonSearch() {
		List<Donor> ls=new ArrayList<Donor>();
		ls.add(new Donor("UNCC","Charlotte","980980","uncc@uncc.edu","5days","uncc.com","Education",1));
		
		ac = new DonorController();
				
		IDonorService av=mock(DonorService.class);
		ac.setDonorService(av);
		mockMvc = MockMvcBuilders.standaloneSetup(ac).build();
		when(av.fetchProvidersBasedOnSearch("Education","Charlotte")).thenReturn(ls);
		
		//When		
		try {
			  mockMvc.perform(get("/AvailableCategories/SearchProviders").param("category", "Education").param("search", "Charlotte"))
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
					.andExpect(jsonPath("$", hasSize(1)))
					.andExpect(jsonPath("$[0].name", is("UNCC")));
					;
					
					
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testFetchProvidersBasedonSearch_InvalidPath() {
		List<Donor> ls=new ArrayList<Donor>();
		ls.add(new Donor("UNCC","Charlotte","980980","uncc@uncc.edu","5days","uncc.com","Education",1));
		
		ac = new DonorController();
				
		IDonorService av=mock(DonorService.class);
		ac.setDonorService(av);
		mockMvc = MockMvcBuilders.standaloneSetup(ac).build();
		when(av.fetchProvidersBasedOnSearch("Education","Charlotte")).thenReturn(ls);
		
		//When		
		try {
			  mockMvc.perform(get("/AvailableCategories/SearchPro").param("category", "Education").param("search", "Charlotte"))
					.andExpect(status().is(404));
					
					
					
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
