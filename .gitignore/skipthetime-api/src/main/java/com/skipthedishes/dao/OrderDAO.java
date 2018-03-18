package com.skipthedishes.dao;

import java.sql.SQLException;

import com.skipthedishes.model.Order;

public interface OrderDAO {
	public void createOrder(Order o) throws SQLException;
	public void deleteOrder(int o) throws SQLException;
	public String getOrderStatus(int o) throws SQLException;
}
