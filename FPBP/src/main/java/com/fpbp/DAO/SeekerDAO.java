package com.fpbp.DAO;

import java.util.List;

import com.fpbp.model.Seeker;

public interface SeekerDAO {

	List<Seeker> fetchProviders(String category);


}
