package com.fpbp.DAO;

import java.util.List;

import com.fpbp.model.Seeker;

public interface SeekerDAO {

	List<Seeker> foodProviders();

	List<Seeker> housingProviders();

	List<Seeker> clothingProviders();

	List<Seeker> educationProviders();

	List<Seeker> moneyProviders();

}
