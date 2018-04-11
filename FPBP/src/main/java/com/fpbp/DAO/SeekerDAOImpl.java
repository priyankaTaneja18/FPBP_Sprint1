package com.fpbp.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.fpbp.model.Seeker;

/*
 * SeekerDAOImpl contains methods to fetch the data for each of the available
 * category of Seeker type 
 */
@Repository
public class SeekerDAOImpl extends JdbcDaoSupport implements SeekerDAO {

	
	
	@Autowired 
	DataSource dataSource;

	private List<Seeker> result;
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}

	public List<Seeker> fetchSeekers(String category) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM helpSeeker where Category=?";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql, new Object[] {category});        
		result = new ArrayList<Seeker>();
		return setSeeker(rows);
	}



	private List<Seeker> setSeeker(List<Map<String, Object>> rows)
	{
		for(Map<String, Object> row:rows){
			Seeker seeker = new Seeker();            
			seeker.setOrgName(((String)row.get("org_name")));
			seeker.setAddress(((String)row.get("address")));
			seeker.setContactNo(((String)row.get("contact_no")));
			seeker.setWebsite((String)row.get("website"));
			seeker.setEmail((String)row.get("email"));
			seeker.setRequirement((String)row.get("requirement"));
			seeker.setQuantity((Integer)row.get("quantity"));
			result.add(seeker);
		}
		return result;
	}
}
