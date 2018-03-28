package com.fpbp.service;

import java.util.List;

import com.fpbp.model.Seeker;

public interface ISeekerService {

	List<Seeker> foodProviders();

	List<Seeker> housingProviders();

	List<Seeker> clothingProviders();

	List<Seeker> educationProviders();

	List<Seeker> moneyProviders();

}
