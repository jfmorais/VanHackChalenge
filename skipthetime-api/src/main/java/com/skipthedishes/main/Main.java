package com.skipthedishes.main;

import java.sql.Connection;
import java.sql.SQLException;

import com.skipthedishes.util.DBConnection;

public class Main {

	public static void main(String[] args) {
//		String springDaoConfigFile = "database.xml";
//		JdbcTemplate jdbcTemplate;
//		DataSource dataSource;
//		XmlBeanFactory beanFactory;
//		FileSystemResource fileSystemResource = new FileSystemResource(springDaoConfigFile);
//		beanFactory = new XmlBeanFactory(fileSystemResource);
//		dataSource = (DataSource) beanFactory.getBean("dataSource");
//		jdbcTemplate = new JdbcTemplate(dataSource);
			
		DBConnection con = DBConnection.getInstance();
		try {
//			Connection x = con.getConnection(jdbcTemplate);
			Connection x = con.getConnection();
			if (x == null) {
                System.out.println("Error trying to get connection");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
