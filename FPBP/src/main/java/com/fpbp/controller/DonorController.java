package com.fpbp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fpbp.model.Donor;
import com.fpbp.service.IDonorService;


@RestController
@RequestMapping("/AvailableCategories")
public class DonorController {
	
	@Autowired
	IDonorService donorService;
	
	@RequestMapping(value="/Provider", method= RequestMethod.GET)
	public List<Donor> fetchSeekers(@RequestParam("category") String category){		
		return donorService.fetchSeekers(category);
	}

	

}
