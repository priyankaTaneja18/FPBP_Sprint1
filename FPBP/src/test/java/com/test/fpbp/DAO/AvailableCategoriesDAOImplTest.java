package com.test.fpbp.DAO;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

import java.util.List;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.fpbp.DAO.AvailableCategoriesDAO;
import com.fpbp.DAO.AvailableCategoriesDAOImpl;
import com.test.fpbp.connection.ConnectionTest;


@RunWith(SpringJUnit4ClassRunner.class)
public class AvailableCategoriesDAOImplTest   {
    private DataSource dataSource;
    private static final String driverClassName = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/fpbpTest?useSSL=false";
    private static final String dbUsername = "root";
    private static final String dbPassword = "root";
    @Test
    public void testFindCategories() {
    	
    	ConnectionTest ct = new ConnectionTest();
    	DataSource ds=ct.getSource();
        //DataSource ds= getSource();
        JdbcTemplate jt = new JdbcTemplate(ds);
        AvailableCategoriesDAO d=new AvailableCategoriesDAOImpl(ds,jt); 
        List<String> categories=d.findCategories();
        assertEquals(categories.size(),5);
        assertEquals(categories.get(0),"Clothing");
        
    }
    public DriverManagerDataSource getSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        return dataSource;
        
    }
}