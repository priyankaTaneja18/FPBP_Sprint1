package com.test.fpbp.DAO;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.fpbp.DAO.AvailableCategoriesDAO;


@Repository
public class AvailableCategoriesDAOImplTest  {


	 private static final String driverClassName = "com.mysql.jdbc.Driver";
	 private static final String url = "jdbc:mysql://localhost:3306/fpbp?useSSL=false";
	 private static final String dbUsername = "root";
	 private static final String dbPassword = "root";
	
	 private static DataSource dataSource;
	
     @Test
	public void seekHelpCategoriesTests() {
	
		 String sql = "SELECT seek_help FROM available_categories_test ";
		 dataSource = getDataSource();
		 JdbcTemplate template = new JdbcTemplate(dataSource);
		 
	 
         List<Map<String, Object>> rows = template.queryForList(sql);        
         List<String> result = new ArrayList<String>();
         for(Map<String, Object> row:rows){
        	result.add((String) row.get("seek_help"));
         }
         assertThat(result.size(), is(4));
	}

		 public DriverManagerDataSource getDataSource() {
			 DriverManagerDataSource dataSource = new DriverManagerDataSource();
			 dataSource.setDriverClassName(driverClassName);
			 dataSource.setUrl(url);
			 dataSource.setUsername(dbUsername);
			 dataSource.setPassword(dbPassword);
			 return dataSource;
		 }

	
}
