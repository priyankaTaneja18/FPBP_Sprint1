package com.fpbp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
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

	
	public void setSeekerService(ISeekerService seekerService) {
		this.seekerService = seekerService;
	}
	
	
	@RequestMapping(value="/Seeker", method= RequestMethod.GET)
	public List<Seeker> fetchSeekers(@RequestParam("category") String category){
			System.out.println("$$$$$$$$"+category);
		return seekerService.fetchSeekers(category);
	}

	

	@RequestMapping(value="/AddSeekerRequirement",consumes = MediaType.APPLICATION_JSON_VALUE, method= RequestMethod.POST)
	public String addSeeker(@RequestBody Seeker s) {
		System.out.println("inside addseeker");
		System.out.println(s.getOrgName()+s.getAddress()+s.getCategory()+s.getContactNo()+s.getWebsite());
		 if( seekerService.addSeeker(s)==true) {
			 return "Entry Added Successfully";
		 }
		 return "Cannot Add";
	}
	

}
