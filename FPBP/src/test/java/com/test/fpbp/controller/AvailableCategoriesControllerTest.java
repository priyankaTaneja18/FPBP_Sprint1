package com.test.fpbp.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpbp.controller.AvailableCategoriesController;
import com.fpbp.model.AvailableCategories;
import com.fpbp.service.AvailableCategoriesService;
import com.fpbp.service.IAvailableCategoriesService;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.*;
import org.springframework.test.context.web.WebAppConfiguration;


public class AvailableCategoriesControllerTest {
	

	private MockMvc mockMvc;
	private AvailableCategoriesController ac;
	
	
	
	@Test
	public void testFindCategories() {
		List<String> ls=new ArrayList<String>();
		ls.add(new String("Food"));
		ac = new AvailableCategoriesController();
		
		IAvailableCategoriesService av=mock(AvailableCategoriesService.class);
		ac.setAvailableCategories(av);
		when(av.findCategories()).thenReturn(ls);
		
		mockMvc = MockMvcBuilders.standaloneSetup(ac).build();
		List<String> list=new ArrayList<String>();
		//When		
		try {
			  mockMvc.perform(get("/AvailableCategories/Category"))
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
					.andExpect(jsonPath("$", hasSize(1)))
					.andExpect(jsonPath("$[0]", is("Food")));
					
					
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	/*
	25 @SpringBootTest
	26 public class BuildingControllerTest {
	27
	28 @Tested(availableDuringSetup=true)
	29 private BuildingController building_controller;
	30
	31 @Injectable
	32 private IBuildingService building_service;
	33
	34 private MockMvc mock_mvc;
	35
	36 private ObjectMapper obj_mapper;
	37
	38 @Before
	39 public void init() {
	40 obj_mapper = new ObjectMapper();
	41 mock_mvc = MockMvcBuilders.standaloneSetup(building_controller).build
	();
	42 }
	43
	44 @Test
	45 public void testSaveBuilding() {
	46 IBuilding test_building = new Building("Test Building");
	47
	48 // Given: Create new building has been invoked (this enables the save
	building functionality)
	49 building_controller.createNewBuilding();
	50
	51 new Expectations() {{
	52 building_service.addBuilding(test_building);
	53 }};
	54
	55 // When: Save new building is called with a building
	56 try {
	57 mock_mvc.perform(post("/university/building/saveBuilding")
	58 .contentType(MediaType.APPLICATION_JSON)
	59 .content(obj_mapper.writeValueAsString(test_building)))
	60 .andExpect(status().isOk());
	61 } catch (Exception e) {
	62 e.printStackTrace();
	63 }
	64

	Page 1

	BuildingControllerTest.java

	65 // Then: The function call that is already set up under "Expectations"
	must occur,
	66 // i.e., the service class must be called with the appropriate
	building parameter
	67 // No further
*/
}
