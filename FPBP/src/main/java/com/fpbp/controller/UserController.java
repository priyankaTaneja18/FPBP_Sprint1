package com.fpbp.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fpbp.model.Users;
import com.fpbp.service.IUserService;

@RestController
@RequestMapping("/Users")
public class UserController {
	
	@Autowired
	IUserService userService;

	@RequestMapping(value="/login",consumes = MediaType.APPLICATION_JSON_VALUE, method= RequestMethod.POST)
	public String validateUser(@RequestBody Users user) {
		String msg=null;
		try {
			msg =userService.validateUser(user.getEmailId(),user.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	@RequestMapping(value="/register",consumes = MediaType.APPLICATION_JSON_VALUE, method= RequestMethod.POST)
	public String registerUser(@RequestBody Users user) {
		String msg=null;
		System.out.println("register is called");
		try {
			msg =userService.registerUser(user.getEmailId(),user.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}
}
