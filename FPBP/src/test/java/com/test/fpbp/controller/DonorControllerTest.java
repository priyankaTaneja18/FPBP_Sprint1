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
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fpbp.controller.DonorController;
import com.fpbp.controller.SeekerController;
import com.fpbp.model.Donor;
import com.fpbp.model.Seeker;
import com.fpbp.service.DonorService;
import com.fpbp.service.IDonorService;
import com.fpbp.service.ISeekerService;
import com.fpbp.service.SeekerService;

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
	
	
	@Test
	public void testAddProvider() {
		
		Donor ls=new Donor("UNCC","Charlotte","980980","uncc@uncc.edu","9:00am-5:00pm","uncc.com","Food",1);
		
		ac = new DonorController();
				
		IDonorService av=mock(DonorService.class);
		ac.setDonorService(av);
		mockMvc = MockMvcBuilders.standaloneSetup(ac).build();
		when(av.addProvider(ls)).thenReturn(true);
		String example = "{\"name\":\"UNCC\",\"address\":\"Charlotte\",\"contactNo\":\"980980\",\"email\":\"uncc@uncc.edu\",\"website:\":\"uncc.com\",\"category\":\"Food\"}";
		//When		
		try {
			
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.post("/AvailableCategories/AddProvider")
					.accept(MediaType.APPLICATION_JSON_UTF8).content(example)
					.contentType(MediaType.APPLICATION_JSON_UTF8);
			
			  mockMvc.perform(requestBuilder)
					.andExpect(status().isOk());
					
					
					
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
		@Test
		public void testAddProvider_InvalidPath() {
			
			Donor ls=new Donor("UNCC","Charlotte","980980","uncc@uncc.edu","9:00am-5:00pm","uncc.com","Food",1);
			
			ac = new DonorController();
					
			IDonorService av=mock(DonorService.class);
			ac.setDonorService(av);
			mockMvc = MockMvcBuilders.standaloneSetup(ac).build();
			when(av.addProvider(ls)).thenReturn(true);
			String example = "{\"name\":\"UNCC\",\"address\":\"Charlotte\",\"contactNo\":\"980980\",\"email\":\"uncc@uncc.edu\",\"website:\":\"uncc.com\",\"category\":\"Food\"}";
			//When		
			try {
				
				RequestBuilder requestBuilder = MockMvcRequestBuilders
						.post("/AvailableCategories/AddP")
						.accept(MediaType.APPLICATION_JSON_UTF8).content(example)
						.contentType(MediaType.APPLICATION_JSON_UTF8);
				
				  mockMvc.perform(requestBuilder)
						.andExpect(status().is(404));
						
						
						
						
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
