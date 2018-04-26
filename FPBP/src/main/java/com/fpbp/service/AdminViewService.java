package com.fpbp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpbp.DAO.AdminViewDAO;
import com.fpbp.model.Donor;
import com.fpbp.model.Seeker;

@Service
public class AdminViewService implements IAdminViewService{


	@Autowired
	AdminViewDAO adminViewDAO;

	public AdminViewService(AdminViewDAO adminViewDAO){
		this.adminViewDAO=adminViewDAO;
	}

	public List<Seeker> findSeekers() {
		// TODO Auto-generated method stub
		return adminViewDAO.findSeekers();
	}


	public boolean deleteSeekers(int id, String tableName)  {
		// TODO Auto-generated method stub
		return adminViewDAO.deleteSeekers(id, tableName);
	}

	public List<Donor> findDonor() {
		return adminViewDAO.findDonor();
	}

}
