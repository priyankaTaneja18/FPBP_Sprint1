package com.fpbp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fpbp.model.Donor;
import com.fpbp.service.IDonorService;


@RestController
@RequestMapping("/AvailableCategories")
public class DonorController {
	
	@Autowired
	IDonorService donorService;
	
	@RequestMapping(value="/FoodDonor", method= RequestMethod.GET)
	public List<Donor> foodDonor(){		
		return donorService.foodDonor();
	}
	@RequestMapping(value="/HousingDonor", method= RequestMethod.GET)
	public List<Donor> HousingDonor(){		
		return donorService.HousingDonor();
	}
	@RequestMapping(value="/ClothingDonor", method= RequestMethod.GET)
	public List<Donor> ClothingDonor(){		
		return donorService.ClothingDonor();
	}
	@RequestMapping(value="/EducationDonor", method= RequestMethod.GET)
	public List<Donor> EducationDonor(){		
		return donorService.EducationDonor();
	}
	@RequestMapping(value="/FinancialDonor", method= RequestMethod.GET)
	public List<Donor> FinancialDonor(){		
		return donorService.FinancialDonor();
	}
	
	

}
