package com.fpbp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fpbp.service.IAvailableCategoriesService;

@RestController
@RequestMapping("/AvailableCategories")
public class AvailableCategoriesController {

	@Autowired
	IAvailableCategoriesService availableCategories;

	@RequestMapping(value="/SeekHelp", method= RequestMethod.GET)
	public List<String> seekHelpCategories(){
		return availableCategories.seekHelpCategories();
	}

	@RequestMapping(value="/Donate", method= RequestMethod.GET)
	public List<String> donateHelpCategories(){
		return availableCategories.donateHelpCategories();
	}	



}
