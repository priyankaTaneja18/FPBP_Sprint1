package com.fpbp.service;

import java.util.List;

import com.fpbp.model.Seeker;

public interface ISeekerService {

	public List<Seeker> fetchSeekers(String category);
	public List<Seeker> fetchSeekersBasedOnSearch(String category,String search);
	public boolean addSeeker(Seeker s);

}
