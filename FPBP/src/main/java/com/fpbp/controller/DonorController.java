package com.fpbp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fpbp.model.Donor;
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
	

}
