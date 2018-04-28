package com.fpbp.DAO;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.fpbp.model.Donor;
import com.fpbp.model.Seeker;

/*
 * DonorDAOImpl contains methods to fetch the data for each of the available
 * category of Donor type 
 */
@Repository
public class DonorDAOImpl extends JdbcDaoSupport implements DonorDAO{

	@Autowired 
	DataSource dataSource;

	JdbcTemplate jdbcTemplate;
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	public DonorDAOImpl(DataSource dataSource, JdbcTemplate jdbcTemplate) {
		this.dataSource = dataSource;
		this.jdbcTemplate = jdbcTemplate;
	}

	

	public List<Donor> fetchProviders(String category) {
		String sql = "SELECT * FROM helpProvider where Category=?" ;
		List<Map<String, Object>> rows =jdbcTemplate.queryForList(sql, new Object[] {category});
				        
		
		return setDonor(rows);
	}


	private List<Donor> setDonor(List<Map<String, Object>> rows)
	{
		List<Donor> result;
		result = new ArrayList<Donor>();
		for(Map<String, Object> row:rows){
			Donor donor = new Donor();            
			donor.setName(((String)row.get("name")));
			donor.setAddress(((String)row.get("address")));
			donor.setContactNo(((String)row.get("contact")));
			donor.setEmail((String)row.get("email"));
			donor.setHoursOfOperation((String)row.get("hours_of_operation"));
			donor.setWebsite((String)row.get("website"));
			result.add(donor);
		}
		return result;
	}

	public List<Donor> fetchProvidersBasedOnSearch(String category, String search) {
		String sql = "SELECT * FROM helpProvider where Category=? and address like('%"+search+"%')" ;
		Object[] params = new Object[] {category };
		int[] types = new int[] { Types.VARCHAR};
		List<Map<String, Object>> rows =jdbcTemplate.queryForList(sql, params, types);
		
		return setDonor(rows);
	}
	

	public boolean addProvider(Donor d) {
		
		String sql = "Insert into fpbp.helpProvider(name,address,contact,email,hours_of_operation, website,Category)"
				+ "values(?,?,?,?,?,?,?)";
	
		
		   Object[] params = new Object[] {d.getName(),d.getAddress(),d.getContactNo(),d.getEmail(),d.getHoursOfOperation(),d.getWebsite(),d.getCategory() };
		    // define SQL types of the arguments
		  int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR };
		// execute insert query to insert the data
		   
		 // return number of row / rows processed by the executed query
		 try {
		  
		  int row = jdbcTemplate.update(sql, params, types);
		     System.out.println(row + " row inserted.");
		     if(row==1)
		    	 return true;
		     else
		    	 return false;
		 }
		 catch(Exception e) {
			return false; 
		 }
	}
	
}
