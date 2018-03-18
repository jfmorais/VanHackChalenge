package com.skipthedishes.dao;

import java.sql.SQLException;

import com.skipthedishes.model.Customer;

public interface CustomerDAO {
	
	public String authenticateCustomer(String email, String password);
	public void createCustomer(Customer c)  throws SQLException ;

}
