package com.fpbp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fpbp.model.Seeker;
import com.fpbp.service.ISeekerService;



@RestController
@RequestMapping("/AvailableCategories")
public class SeekerController {

	@Autowired
	ISeekerService seekerService;

	@RequestMapping(value="/FoodSeeker", method= RequestMethod.GET)
	public List<Seeker> foodProviders(){
		return seekerService.foodProviders();
	}

	@RequestMapping(value="/HousingSeeker", method= RequestMethod.GET)
	public List<Seeker> housingProviders(){
		return seekerService.housingProviders();
	}
	
	@RequestMapping(value="/ClothingSeeker", method= RequestMethod.GET)
	public List<Seeker> clothingProviders(){
		return seekerService.clothingProviders();
	}
	
	@RequestMapping(value="/EducationSeeker", method= RequestMethod.GET)
	public List<Seeker> educationProviders(){
		return seekerService.educationProviders();
	}
	
	@RequestMapping(value="/FinancialSeeker", method= RequestMethod.GET)
	public List<Seeker> moneyProviders(){
		return seekerService.moneyProviders();
	}
	/*@RequestMapping(value="/Donate", method= RequestMethod.GET)
	public List<String> donateHelpCategories(){
		return availableCategories.donateHelpCategories();
	}	*/



}
