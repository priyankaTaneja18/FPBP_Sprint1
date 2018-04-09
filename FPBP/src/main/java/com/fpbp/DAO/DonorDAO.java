package com.fpbp.DAO;

import java.util.List;

import com.fpbp.model.Donor;


public interface DonorDAO {

	List<Donor> fetchSeekers(String category);


}
