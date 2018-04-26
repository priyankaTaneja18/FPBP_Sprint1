package com.fpbp.DAO;

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
@Repository
public class AdminViewDAOImpl extends JdbcDaoSupport implements AdminViewDAO {
	private List<Seeker> result;
	private List<Donor> donors; 
	@Autowired 
    DataSource dataSource;
    JdbcTemplate jdbcTemplate;
    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
        jdbcTemplate=new JdbcTemplate(dataSource);
    }
    
    public AdminViewDAOImpl() {
    }
    public AdminViewDAOImpl(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }
    
	public List<Seeker> findSeekers() {
		String sql = "SELECT * FROM helpSeeker";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);        
		result = new ArrayList<Seeker>();
		return setSeeker(rows);
	}
	   
	private List<Seeker> setSeeker(List<Map<String, Object>> rows)
	{
		for(Map<String, Object> row:rows){
			Seeker seeker = new Seeker();      
			seeker.setSid((Integer) row.get("pid"));
			seeker.setOrgName(((String)row.get("org_name")));
			seeker.setAddress(((String)row.get("address")));
			seeker.setContactNo(((String)row.get("contact_no")));
			seeker.setWebsite((String)row.get("website"));
			seeker.setEmail((String)row.get("email"));
			seeker.setRequirement((String)row.get("requirement"));
			seeker.setQuantity((Integer)row.get("quantity"));
			seeker.setCategory((String)row.get("Category"));
			result.add(seeker);
		}
		return result;
	}

	public boolean deleteSeekers(int id, String tableName){
		String deleteQuery = "delete from "+tableName+ " where pid = ?";
		int i = jdbcTemplate.update(deleteQuery, id);
		if(i==1) 
			return true;
		else
			return false;
	}

	public List<Donor> findDonor() {
		String sql = "SELECT * FROM helpProvider";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);        
		donors = new ArrayList<Donor>();
		return setDonor(rows);
	}
	
	private List<Donor> setDonor(List<Map<String, Object>> rows)
	{
		for(Map<String, Object> row:rows){
			Donor donor = new Donor(); 
			donor.setId((Integer) row.get("pid"));
			donor.setName(((String)row.get("name")));
			donor.setAddress(((String)row.get("address")));
			donor.setContactNo(((String)row.get("contact")));
			donor.setEmail(((String)row.get("email")));
			donor.setHoursOfOperation(((String)row.get("hours_of_operation")));
			donor.setWebsite(((String)row.get("website")));
			donor.setCategory(((String)row.get("category")));
			donors.add(donor);
		}
		return donors;
	}
}
