package com.fpbp.service;

import java.util.List;

import com.fpbp.model.Donor;
import com.fpbp.model.Seeker;

public interface IAdminViewService {

	public List<Seeker> findSeekers();

	public boolean deleteSeekers(int id, String tableName);

	public List<Donor> findDonor();

}
