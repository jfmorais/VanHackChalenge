package com.skipthedishes.util;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.JdbcTemplate;

public class DBConnection {
	
	private String springDaoConfigFile = "database.xml";
	
	private FileSystemResource fileSystemResource = new FileSystemResource(springDaoConfigFile);
	private XmlBeanFactory beanFactory  = new XmlBeanFactory(fileSystemResource);
	private DataSource dataSource = (DataSource) beanFactory.getBean("dataSource");
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	private static DBConnection instance;
	private Connection connection;
	
	public static DBConnection getInstance(){
		if ( instance == null )
			instance = new DBConnection();
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		if ( connection == null ){
			 connection = jdbcTemplate.getDataSource().getConnection();
		}	
		return connection;
	}

	
}
