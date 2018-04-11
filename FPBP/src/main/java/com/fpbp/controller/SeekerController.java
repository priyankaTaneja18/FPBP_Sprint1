package com.fpbp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fpbp.model.Seeker;
import com.fpbp.service.ISeekerService;



@RestController
@RequestMapping("/AvailableCategories")
public class SeekerController {

	@Autowired
	ISeekerService seekerService;

	@RequestMapping(value="/Seeker", method= RequestMethod.GET)
	public List<Seeker> fetchSeekers(@RequestParam("category") String category){
			System.out.println("$$$$$$$$"+category);
		return seekerService.fetchSeekers(category);
	}

	
	

}
