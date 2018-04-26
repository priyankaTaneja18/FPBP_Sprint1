package com.test.fpbp.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fpbp.controller.SeekerController;
import com.fpbp.controller.UserController;
import com.fpbp.model.Seeker;
import com.fpbp.model.Users;
import com.fpbp.service.ISeekerService;
import com.fpbp.service.IUserService;
import com.fpbp.service.SeekerService;
import com.fpbp.service.UserService;

public class UserControllerTest {
	
	

	private MockMvc mockMvc;
	private UserController ac;
	

	@Test
	public void testValidateUser() {
		
		Users ls=new Users("users@test.com","test");
		
		ac = new UserController();
				
		IUserService av=mock(UserService.class);
		ac.setUserService(av);
		mockMvc = MockMvcBuilders.standaloneSetup(ac).build();
		String example = "{\"emailId\":\"user@test.com\",\"password\":\"test\"}";
		try {
			when(av.validateUser("users@test.com","test")).thenReturn("Login Successful");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//String example = "
		try {
			
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.post("/Users/login")
					.accept(MediaType.APPLICATION_JSON_UTF8).content(example)
					.contentType(MediaType.APPLICATION_JSON_UTF8);
			
			  mockMvc.perform(requestBuilder)
					.andExpect(status().isOk())
					;
					
					
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
public void testRegisterUser() {
		
		Users ls=new Users("users@test.com","test");
		
		ac = new UserController();
				
		IUserService av=mock(UserService.class);
		ac.setUserService(av);
		mockMvc = MockMvcBuilders.standaloneSetup(ac).build();
		String example = "{\"emailId\":\"user@test.com\",\"password\":\"test\"}";
		try {
			when(av.registerUser("users@test.com","test")).thenReturn("Account Created Successfully");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//String example = "
		try {
			
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.post("/Users/register")
					.accept(MediaType.APPLICATION_JSON_UTF8).content(example)
					.contentType(MediaType.APPLICATION_JSON_UTF8);
			
			
			  mockMvc.perform(requestBuilder)
					.andExpect(status().isOk())
					;
					
					
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
