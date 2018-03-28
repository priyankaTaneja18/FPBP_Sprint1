package com.fpbp.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.fpbp.model.Donor;

/*
 * DonorDAOImpl contains methods to fetch the data for each of the available
 * category of Donor type 
 */
@Repository
public class DonorDAOImpl extends JdbcDaoSupport implements DonorDAO{

	@Autowired 
	DataSource dataSource;

	private List<Donor> result;
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}

	public List<Donor> foodDonor() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM donate_food";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);        
		result = new ArrayList<Donor>();
		return setDonor(rows);
	}

	public List<Donor> FinancialDonor() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM donate_money";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);        
		result = new ArrayList<Donor>();
		return setDonor(rows);		       
	}

	public List<Donor> EducationDonor() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM donate_education";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);        
		result = new ArrayList<Donor>();
		return setDonor(rows);
	}

	public List<Donor> ClothingDonor() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM donate_clothing";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);        
		result = new ArrayList<Donor>();
		return setDonor(rows);

	}

	public List<Donor> HousingDonor() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM donate_housing";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);        
		result = new ArrayList<Donor>();
		return setDonor(rows);

	}

	private List<Donor> setDonor(List<Map<String, Object>> rows)
	{
		for(Map<String, Object> row:rows){
			Donor donor = new Donor();            
			donor.setOrgName(((String)row.get("org_name")));
			donor.setAddress(((String)row.get("address")));
			donor.setContactNo(((String)row.get("contact_no")));
			donor.setWebsite((String)row.get("website"));
			donor.setEmail((String)row.get("email"));
			donor.setRequirement((String)row.get("requirement"));
			donor.setQuantity((Integer)row.get("quantity"));
			result.add(donor);
		}
		return result;
	}
}
