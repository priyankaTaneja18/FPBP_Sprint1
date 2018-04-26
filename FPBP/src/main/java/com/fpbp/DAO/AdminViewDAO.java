package com.fpbp.DAO;

import java.util.List;

import com.fpbp.model.Donor;
import com.fpbp.model.Seeker;

public interface AdminViewDAO {

	List<Seeker> findSeekers();

	boolean deleteSeekers(int id, String tableName);

	List<Donor> findDonor();

}
