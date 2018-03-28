package com.fpbp.DAO;

import java.util.List;

import com.fpbp.model.Donor;


public interface DonorDAO {

	List<Donor> foodDonor();

	List<Donor> FinancialDonor();

	List<Donor> EducationDonor();

	List<Donor> ClothingDonor();

	List<Donor> HousingDonor();
}
