package com.fpbp.service;

import java.util.List;

import com.fpbp.model.Seeker;

public interface ISeekerService {

	List<Seeker> fetchSeekers(String category);

	

}
