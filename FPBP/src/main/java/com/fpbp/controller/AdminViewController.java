package com.fpbp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fpbp.model.Donor;
import com.fpbp.model.Seeker;
import com.fpbp.service.IAdminViewService;

@RestController
@RequestMapping("/AdminView")
public class AdminViewController {
	
	
		@Autowired
		private IAdminViewService adminViewService;

		

		public void setAdminViewService(IAdminViewService adminViewService) {
			this.adminViewService = adminViewService;
		}

		@RequestMapping(value="/Seeker", method= RequestMethod.GET)
		public List<Seeker> findSeekers(){
			return adminViewService.findSeekers();
		}	
		
		@RequestMapping(value="/Donor", method= RequestMethod.GET)
		public List<Donor> findDonor(){
			return adminViewService.findDonor();
		}
		
		@RequestMapping(value="/Delete", consumes = MediaType.APPLICATION_JSON_VALUE,method= RequestMethod.POST)
		public boolean delete(@RequestParam("id") int id, @RequestBody Map<String,String> tableName){
			String tname= tableName.get("tableName");
			return adminViewService.deleteSeekers(id,tname);
		}
}
