package com.skipthedishes.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skipthedishes.dao.ProductDAO;
import com.skipthedishes.dao.ProductDAOImpl;
import com.skipthedishes.model.Product;

@RestController
@RequestMapping("/Product")
public class ProductController {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Product> getProducts() {
		List<Product> list = null;
		try {

            ProductDAO c = new ProductDAOImpl();	
            list = c.getProducts();
        
        } catch (Exception e) {
            e.printStackTrace();
        } 
		return list;
	}
}
