package com.skipthedishes.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.skipthedishes.model.Product;
import com.skipthedishes.util.DBConnection;

public class ProductDAOImpl implements ProductDAO {
	
	public List<Product> getProducts() throws SQLException {
		Connection con = null ;
		List<Product> listOfProducts= new ArrayList<Product>();
		try {
			PreparedStatement preparedStatement = null;
			DBConnection db = DBConnection.getInstance();
            con = db.getConnection();
            
            String findUser = "SELECT * FROM PRODUCT";
            preparedStatement = (PreparedStatement) con.prepareStatement(findUser);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt(1));
				p.setStoreId(rs.getInt(2));
				p.setName(rs.getString(3));
				p.setDescription(rs.getString(4));
				p.setPrice(rs.getDouble(5));
				listOfProducts.add(p);
			
			}
			con.close();
			return listOfProducts;
			
        } catch (SQLException e) {
        	throw new SQLException(e.getMessage());
           
        } 
		
	}

}
