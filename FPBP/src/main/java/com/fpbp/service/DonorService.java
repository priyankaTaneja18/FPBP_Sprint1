package com.fpbp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpbp.DAO.DonorDAO;
import com.fpbp.model.Donor;
import com.fpbp.model.Seeker;


@Service
public class DonorService implements IDonorService {


     @Autowired
     DonorDAO donorDAO;
    
    public DonorService(DonorDAO donorDAO){
        this.donorDAO=donorDAO;
    }
    
	
	public List<Donor> fetchProviders(String category) {
		return donorDAO.fetchProviders(category);
	}


	public List<Donor> fetchProvidersBasedOnSearch(String category, String search) {
		// TODO Auto-generated method stub
		return donorDAO.fetchProvidersBasedOnSearch(category,search);
	}


	public boolean addProvider(Donor d) {
		return donorDAO.addProvider(d);
	}

}
