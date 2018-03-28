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
import com.fpbp.model.Seeker;

/*
 * SeekerDAOImpl contains methods to fetch the data for each of the available
 * category of Seeker type 
 */
@Repository
public class SeekerDAOImpl extends JdbcDaoSupport implements SeekerDAO {

	@Autowired 
	DataSource dataSource;

	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	private List<Seeker> result;

	public List<Seeker> foodProviders() {
		String sql = "SELECT * FROM seek_food ";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);        
		result = new ArrayList<Seeker>();
		return setSeeker(rows);
	}


	public List<Seeker> housingProviders() {
		String sql = "SELECT * FROM seek_housing ";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);        
		result = new ArrayList<Seeker>();
		return setSeeker(rows);
	}


	public List<Seeker> clothingProviders() {
		String sql = "SELECT * FROM seek_clothing ";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		result = new ArrayList<Seeker>();
		return setSeeker(rows);

	}


	public List<Seeker> educationProviders() {
		String sql = "SELECT * FROM seek_education ";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);  
		result = new ArrayList<Seeker>();
		return setSeeker(rows);

	}


	public List<Seeker> moneyProviders() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM seek_money ";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);   
		result = new ArrayList<Seeker>();
		return setSeeker(rows);


	}

	private List<Seeker> setSeeker(List<Map<String, Object>> rows)
	{
		for(Map<String, Object> row:rows){
			Seeker seeker = new Seeker();            
			seeker.setName(((String)row.get("name")));
			seeker.setAddress(((String)row.get("address")));
			seeker.setContactNo(((String)row.get("contact")));
			seeker.setEmail((String)row.get("email"));
			seeker.setHoursOfOperation((String)row.get("hours_of_operation"));
			seeker.setWebsite((String)row.get("webite"));
			result.add(seeker);
		}
		return result;
	}
}
