package com.fpbp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpbp.DAO.SeekerDAO;
import com.fpbp.model.Seeker;


@Service
public class SeekerService implements ISeekerService {


     @Autowired
     SeekerDAO seekerDAO;
    
    public SeekerService(SeekerDAO seekerDAO){
        this.seekerDAO=seekerDAO;
    }
    
	
	public List<Seeker> foodProviders() {
		return seekerDAO.foodProviders();
	}


	public List<Seeker> housingProviders() {
		// TODO Auto-generated method stub
		return seekerDAO.housingProviders();
	}


	public List<Seeker> clothingProviders() {
		// TODO Auto-generated method stub
		return seekerDAO.clothingProviders();
	}


	public List<Seeker> educationProviders() {
		// TODO Auto-generated method stub
		return seekerDAO.educationProviders();
	}


	public List<Seeker> moneyProviders() {
		// TODO Auto-generated method stub
		return seekerDAO.moneyProviders();
	}	
}
