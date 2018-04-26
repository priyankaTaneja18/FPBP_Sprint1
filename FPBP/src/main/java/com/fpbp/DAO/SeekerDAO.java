package com.fpbp.DAO;

import java.util.List;

import com.fpbp.model.Seeker;



public interface SeekerDAO {

	List<Seeker> fetchSeekers(String category);
	List<Seeker> fetchSeekersBasedOnSearch(String category,String search);
	public boolean addSeeker(Seeker s);
}
