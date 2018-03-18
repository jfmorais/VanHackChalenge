package com.skipthedishes.dao;

import java.sql.SQLException;
import java.util.List;

import com.skipthedishes.model.Product;

public interface ProductDAO {
	public List<Product> getProducts() throws SQLException;
}
