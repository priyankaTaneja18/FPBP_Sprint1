package com.fpbp.service;

import java.util.List;

import com.fpbp.model.Donor;

public interface IDonorService {

	List<Donor> fetchSeekers(String category);

	

}
