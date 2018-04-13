package com.test.fpbp.connection;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ConnectionTest {
	
    private static final String driverClassName = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/fpbpTest?useSSL=false";
    private static final String dbUsername = "root";
    private static final String dbPassword = "root";
    
    public DriverManagerDataSource getSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }   
}
