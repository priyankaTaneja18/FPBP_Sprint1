package com.fpbp.DAO;

import java.util.List;

import com.fpbp.model.Donor;


public interface DonorDAO {

	List<Donor> fetchProviders(String category);
	List<Donor> fetchProvidersBasedOnSearch(String category,String search);

}
