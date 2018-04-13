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
/*
 * AvailableCategoriesDAOImpl used to fetch the values for Categories
 * for Donors and Seekers 
 */
@Repository
public class AvailableCategoriesDAOImpl extends JdbcDaoSupport implements AvailableCategoriesDAO {
    @Autowired 
    DataSource dataSource;
    JdbcTemplate jdbcTemplate;
    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
        jdbcTemplate=new JdbcTemplate(dataSource);
    }
    public AvailableCategoriesDAOImpl() {
    }
    public AvailableCategoriesDAOImpl(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<String> findCategories() {
        String sql = "SELECT * FROM available_categories ";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);        
        List<String> result = new ArrayList<String>();
        for(Map<String, Object> row:rows){
            result.add((String) row.get("Category"));
        }
        return result;
    }
}