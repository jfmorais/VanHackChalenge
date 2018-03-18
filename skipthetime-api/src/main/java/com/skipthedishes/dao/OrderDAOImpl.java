package com.skipthedishes.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.GeneratorStrategy;

import com.mysql.jdbc.PreparedStatement;
import com.skipthedishes.model.Customer;
import com.skipthedishes.model.Order;
import com.skipthedishes.model.OrderItems;
import com.skipthedishes.model.Product;
import com.skipthedishes.util.DBConnection;
import com.skipthedishes.util.IDGenerator;

public class OrderDAOImpl implements OrderDAO{
	
	@Autowired
	private IDGenerator idGenerator;
	
	public void createOrder(Order o) throws SQLException {
		String message = null;
		Calendar calendar = Calendar.getInstance();
		int orderID = idGenerator.getNextId();
	    java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
	    
		try {
			PreparedStatement preparedStatement = null;
			DBConnection db = DBConnection.getInstance();
            Connection con = db.getConnection();
            
            String order = "INSERT INTO ORDER (id, date, customerId, deliveryAddress, contact, storeId,total, status, lastUpdate) VALUES (?, ?, ?, ?, ?,?,?,?,?)";
            preparedStatement = (PreparedStatement) con.prepareStatement(order);
			preparedStatement.setInt(1, orderID);
			preparedStatement.setString(2, startDate.toString());
			preparedStatement.setInt(3, o.getCustomerId());
			preparedStatement.setString(4, o.getDeliveryAddress());
			preparedStatement.setString(5, o.getContact());
			preparedStatement.setInt(6, o.getStoreId());
			
			o.calculateTotal();
			preparedStatement.setDouble(7, o.getTotal());//TOtal
			preparedStatement.setString(8, o.getStatus());
			preparedStatement.setString(9, o.getLastUpdate());
			
			preparedStatement.executeUpdate();
			
			//call dao to insert orderitems
			for (OrderItems oi : o.getOrderItems()) {
				String orderItems = "INSERT INTO ORDERITEM (id, orderId, productId, price, quantity, total) VALUES (?, ?, ?, ?, ?,?)";
				preparedStatement = (PreparedStatement) con.prepareStatement(orderItems);
				preparedStatement.setInt(1, idGenerator.getNextId());
				preparedStatement.setInt(2, orderID);
				preparedStatement.setInt(3, oi.getProductId());
				preparedStatement.setDouble(4, oi.getPrice());
				preparedStatement.setInt(5, oi.getQuantity());
				oi.calculateTotal();
				preparedStatement.setDouble(6, oi.getTotal());
				preparedStatement.executeUpdate();
			}
			
			con.close();
			
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        } 
	}

	@Override
	public void deleteOrder(int orderId) throws SQLException {
		String message = null;
		 
		try {
			PreparedStatement preparedStatement = null;
			DBConnection db = DBConnection.getInstance();
            Connection con = db.getConnection();
            
            String order = "DELETE FROM ORDER WHERE ORDERID = ?";
            preparedStatement = (PreparedStatement) con.prepareStatement(order);
			preparedStatement.setInt(1, orderId);
			
			preparedStatement.executeUpdate();
			
			//call dao to insert orderitems
			String orderItems = "DELETE FROM ORDER WHERE ORDERID = ?";
			preparedStatement = (PreparedStatement) con.prepareStatement(orderItems);
			preparedStatement.setInt(1, orderId);
			
			
			con.close();
			
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        } 
		
	}
	
	@Override
	public String getOrderStatus(int orderId) throws SQLException {
		String message = null;
		 
		try {
			PreparedStatement preparedStatement = null;
			DBConnection db = DBConnection.getInstance();
            Connection con = db.getConnection();
            
            String order = "SELECT STATUS FROM ORDER WHERE ORDERID = ?";
            preparedStatement = (PreparedStatement) con.prepareStatement(order);
			preparedStatement.setInt(1, orderId);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				message = rs.getString(1);
			}
			
			con.close();
			
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        } 
		
		return message ;
	}

}
