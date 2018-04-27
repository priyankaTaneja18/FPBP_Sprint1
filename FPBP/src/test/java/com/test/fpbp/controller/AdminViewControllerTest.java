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

import com.fpbp.controller.AdminViewController;
import com.fpbp.model.Donor;
import com.fpbp.model.Seeker;
import com.fpbp.service.AdminViewService;
import com.fpbp.service.IAdminViewService;

public class AdminViewControllerTest {

	private MockMvc mockMvc;
	private AdminViewController ac;

	@Test
	public void testFindSeekers() {
		List<Seeker> ls=new ArrayList<Seeker>();
		ls.add(new Seeker("UNCCOrg","Charlotte","980980","uncc.com","uncc@uncc.edu","Food",50,"Food",1));

		ac = new AdminViewController();

		IAdminViewService av=mock(AdminViewService.class);
		ac.setAdminViewService(av);
		mockMvc = MockMvcBuilders.standaloneSetup(ac).build();
		when(av.findSeekers()).thenReturn(ls);

		//When		
		try {
			mockMvc.perform(get("/AdminView/Seeker"))
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
	public void testFindDonor() {
		List<Donor> ls=new ArrayList<Donor>();
		ls.add(new Donor("UNCC","Charlotte","980980","uncc@uncc.edu","5days","uncc.com","Education",1));

		ac = new AdminViewController();

		IAdminViewService av=mock(AdminViewService.class);
		ac.setAdminViewService(av);
		mockMvc = MockMvcBuilders.standaloneSetup(ac).build();
		when(av.findDonor()).thenReturn(ls);

		//When		
		try {
			mockMvc.perform(get("/AdminView/Donor"))
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
	public void testDeleteDonors() {

		ac = new AdminViewController();

		IAdminViewService av=mock(AdminViewService.class);
		ac.setAdminViewService(av);
		mockMvc = MockMvcBuilders.standaloneSetup(ac).build();
		when(av.deleteSeekers(1, "helpProvider")).thenReturn(true);
		String example = "{\"tableName\":\"helpProvider\"}";
		//When		
		try {		
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.post("/AdminView/Delete").param("id", "1")
					.accept(MediaType.APPLICATION_JSON_UTF8).content(example)
					.contentType(MediaType.APPLICATION_JSON_UTF8);

			mockMvc.perform(requestBuilder)
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", is(true)));
			;


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteSeekers() {

		ac = new AdminViewController();

		IAdminViewService av=mock(AdminViewService.class);
		ac.setAdminViewService(av);
		mockMvc = MockMvcBuilders.standaloneSetup(ac).build();
		when(av.deleteSeekers(1, "helpSeeker")).thenReturn(false);
		String example = "{\"tableName\":\"helpSeeker\"}";
		//When		
		try {		
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.post("/AdminView/Delete").param("id", "1")
					.accept(MediaType.APPLICATION_JSON_UTF8).content(example)
					.contentType(MediaType.APPLICATION_JSON_UTF8);

			mockMvc.perform(requestBuilder)
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", is(false)));
			;


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteInvalid() {

		ac = new AdminViewController();

		IAdminViewService av=mock(AdminViewService.class);
		ac.setAdminViewService(av);
		mockMvc = MockMvcBuilders.standaloneSetup(ac).build();
		when(av.deleteSeekers(1, "helpSeeker")).thenReturn(true);
		String example = "{\"tableName\":\"helpSeeker\"}";
		//When		
		try {		
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.post("/AdminView/Deleteee").param("id", "1")
					.accept(MediaType.APPLICATION_JSON_UTF8).content(example)
					.contentType(MediaType.APPLICATION_JSON_UTF8);

			mockMvc.perform(requestBuilder)
			.andExpect(status().is(404))
			;


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
