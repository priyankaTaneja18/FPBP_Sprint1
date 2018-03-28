package com.fpbp.service;

import java.util.List;

import com.fpbp.model.Donor;

public interface IDonorService {

	List<Donor> foodDonor();

	List<Donor> HousingDonor();

	List<Donor> ClothingDonor();

	List<Donor> EducationDonor();

	List<Donor> FinancialDonor();

}
