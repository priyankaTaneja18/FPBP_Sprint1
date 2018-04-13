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
	private IAvailableCategoriesService availableCategories;

	public void setAvailableCategories(IAvailableCategoriesService availableCategories) {
		this.availableCategories = availableCategories;
	}

	@RequestMapping(value="/Category", method= RequestMethod.GET)
	public List<String> findCategories(){
		return availableCategories.findCategories();
	}
}
