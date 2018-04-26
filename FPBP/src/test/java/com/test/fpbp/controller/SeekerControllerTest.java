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

import com.fpbp.controller.SeekerController;
import com.fpbp.model.Seeker;
import com.fpbp.service.SeekerService;
import com.fpbp.service.ISeekerService;

public class SeekerControllerTest {
	


	private MockMvc mockMvc;
	private SeekerController ac;
		
	
	@Test
	public void testFetchSeekers() {
		List<Seeker> ls=new ArrayList<Seeker>();
		ls.add(new Seeker("UNCCOrg","Charlotte","980980","uncc.com","uncc@uncc.edu","Food",50,"Food"));
		
		ac = new SeekerController();
				
		ISeekerService av=mock(SeekerService.class);
		ac.setSeekerService(av);
		mockMvc = MockMvcBuilders.standaloneSetup(ac).build();
		when(av.fetchSeekers("Food")).thenReturn(ls);
		
		//When		
		try {
			  mockMvc.perform(get("/AvailableCategories/Seeker").param("category", "Food"))
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
					.andExpect(jsonPath("$", hasSize(1)))
					.andExpect(jsonPath("$[0].orgName", is("UNCCOrg")));
					
					
					
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	@Test
	public void testAddSeeker() {
		
		Seeker ls=new Seeker("UNCCOrg","Charlotte","980980","uncc.com","uncc@uncc.edu","Food",50,"Food");
		
		ac = new SeekerController();
				
		ISeekerService av=mock(SeekerService.class);
		ac.setSeekerService(av);
		mockMvc = MockMvcBuilders.standaloneSetup(ac).build();
		when(av.addSeeker(ls)).thenReturn(true);
		String example = "{\"orgName\":\"UNCCOrg\",\"address\":\"Charlotte\",\"contactNo\":\"980980\",\"website:\":\"uncc.com\",\"email\":\"uncc@uncc.edu\",\"requirement\":\"\",\"quantity\":\"2\",\"category\":\"Food\"}";
		//When		
		try {
			
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.post("/AvailableCategories/AddSeekerRequirement")
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
	public void testFetchSeekersBasedOnSearch() {
		List<Seeker> ls=new ArrayList<Seeker>();
		ls.add(new Seeker("UNCCOrg","Charlotte","980980","uncc.com","uncc@uncc.edu","Food",50,"Food"));
		
		ac = new SeekerController();
				
		ISeekerService av=mock(SeekerService.class);
		ac.setSeekerService(av);
		mockMvc = MockMvcBuilders.standaloneSetup(ac).build();
		when(av.fetchSeekersBasedOnSearch("Food","Charlotte")).thenReturn(ls);
		
		//When		
		try {
			  mockMvc.perform(get("/AvailableCategories/SearchSeeker").param("category", "Food").param("search","Charlotte"))
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
					.andExpect(jsonPath("$", hasSize(1)))
					.andExpect(jsonPath("$[0].orgName", is("UNCCOrg")));
					
					
					
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testFetchSeekersBasedOnSearch_InvalidPath() {
		List<Seeker> ls=new ArrayList<Seeker>();
		ls.add(new Seeker("UNCCOrg","Charlotte","980980","uncc.com","uncc@uncc.edu","Food",50,"Food"));
		
		ac = new SeekerController();
				
		ISeekerService av=mock(SeekerService.class);
		ac.setSeekerService(av);
		mockMvc = MockMvcBuilders.standaloneSetup(ac).build();
		when(av.fetchSeekersBasedOnSearch("Food","Charlotte")).thenReturn(ls);
		
		//When		
		try {
			  mockMvc.perform(get("/AvailableCategories/Seek").param("category", "Food").param("search","Charlotte"))
					.andExpect(status().is(404));
					
					
					
					
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
