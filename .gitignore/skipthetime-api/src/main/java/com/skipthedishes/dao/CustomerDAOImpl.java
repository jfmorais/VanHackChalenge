package com.skipthedishes.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;

import com.mysql.jdbc.PreparedStatement;
import com.skipthedishes.model.Customer;
import com.skipthedishes.util.DBConnection;
import com.skipthedishes.util.IDGenerator;

public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private IDGenerator idGenerator;
	
	public String authenticateCustomer(String username,String password) {
		String message = null;
		Connection con = null ;
		try {
			PreparedStatement preparedStatement = null;
			DBConnection db = DBConnection.getInstance();
            con = db.getConnection();
            
            String findUser = "SELECT * FROM CUSTOMERS WHERE EMAIL = ? AND PASSWORD = ?";
            preparedStatement = (PreparedStatement) con.prepareStatement(findUser);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
           
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {

				message = "Authorized "+ rs.getString(3); //get Name from BD
			
			}
			con.close();
			return message;
			
        } catch (SQLException e) {
        	return message = "Not Found";
           
        } 
		
	}

	public void createCustomer(Customer c) throws SQLException {
		String message = null;
		Calendar calendar = Calendar.getInstance();
	    java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
	    
		try {
			PreparedStatement preparedStatement = null;
			DBConnection db = DBConnection.getInstance();
            Connection con = db.getConnection();
            
            String findUser = "INSERT INTO CUSTOMERS (id,email, name, address, creation, password) VALUES (?,?, ?, ?, ?, ?)";
            preparedStatement = (PreparedStatement) con.prepareStatement(findUser);
            preparedStatement.setInt(1, idGenerator.getNextId());
			preparedStatement.setString(2, c.getEmail());
			preparedStatement.setString(3, c.getName());
			preparedStatement.setString(4, c.getAddress());
			preparedStatement.setDate(5, startDate);
			preparedStatement.setString(6, c.getPassword());
			
			preparedStatement.executeUpdate();
			
			
			con.close();
			
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        } 
	}
	
}
