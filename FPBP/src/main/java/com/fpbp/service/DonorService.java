package com.fpbp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpbp.DAO.DonorDAO;
import com.fpbp.model.Donor;


@Service
public class DonorService implements IDonorService {


     @Autowired
     DonorDAO donorDAO;
    
    public DonorService(DonorDAO donorDAO){
        this.donorDAO=donorDAO;
    }
    
	
	public List<Donor> foodDonor() {
		return donorDAO.foodDonor();
	}


	public List<Donor> HousingDonor() {
		// TODO Auto-generated method stub
		return donorDAO.HousingDonor();
	}


	public List<Donor> ClothingDonor() {
		// TODO Auto-generated method stub
		return donorDAO.ClothingDonor();
	}


	public List<Donor> EducationDonor() {
		// TODO Auto-generated method stub
		return donorDAO.EducationDonor();
	}


	public List<Donor> FinancialDonor() {
		// TODO Auto-generated method stub
		return donorDAO.FinancialDonor();
	}	
}
