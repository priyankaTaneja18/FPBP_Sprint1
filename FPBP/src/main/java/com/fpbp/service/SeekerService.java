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
    
	
	public List<Seeker> fetchSeekers(String category) {
		return seekerDAO.fetchSeekers(category);
	}

	public boolean addSeeker(Seeker s) {
		return seekerDAO.addSeeker(s);
	}
	
}
