package com.fpbp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fpbp.model.Donor;
import com.fpbp.model.Seeker;
import com.fpbp.service.IDonorService;
import com.fpbp.service.ISeekerService;


@RestController
@RequestMapping("/AvailableCategories")
public class DonorController {
	

	@Autowired
	IDonorService donorService;
	
	

	public void setDonorService(IDonorService donorService) {
		this.donorService = donorService;
	}



	@RequestMapping(value="/Providers", method= RequestMethod.GET)
	public List<Donor> fetchProviders(@RequestParam("category") String category){
			System.out.println("$$$$$$$$"+category);
		return donorService.fetchProviders(category);
	}
	
	@RequestMapping(value="/SearchProviders", method= RequestMethod.GET)
	public List<Donor> fetchProvidersBasedonSearch(@RequestParam("category") String category,@RequestParam("search") String search){
			
		return donorService.fetchProvidersBasedOnSearch(category, search);
	}
	
	@RequestMapping(value="/AddProvider",consumes = MediaType.APPLICATION_JSON_VALUE, method= RequestMethod.POST)
	public String addSeeker(@RequestBody Donor s) {
		System.out.println("inside donor");
		System.out.println(s.getName()+s.getAddress()+s.getCategory()+s.getContactNo()+s.getWebsite());
		 if( donorService.addProvider(s)==true) {
			 return "Entry Added Successfully";
		 }
		 return "Cannot Add";
	}

}
