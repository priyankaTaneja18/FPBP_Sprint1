package com.fpbp.service;

import java.util.List;

import com.fpbp.model.Donor;

public interface IDonorService {

	List<Donor> fetchProviders(String category);
	List<Donor> fetchProvidersBasedOnSearch(String category,String search);
	

}
