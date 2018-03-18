package com.skipthedishes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skipthedishes.dao.OrderDAO;
import com.skipthedishes.dao.OrderDAOImpl;
import com.skipthedishes.dao.ProductDAO;
import com.skipthedishes.dao.ProductDAOImpl;
import com.skipthedishes.model.Order;
import com.skipthedishes.model.Product;

@RestController
@RequestMapping("/Order")
public class OrderController {
	
	@RequestMapping(method = RequestMethod.POST)
	public String createOrder(Order order) {
		String msg = null;
		
		try {

            OrderDAO c = new OrderDAOImpl();	
            c.createOrder(order);
        
        } catch (Exception e) {
            e.printStackTrace();
        } 
		return msg;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteOrder(@PathVariable int orderId) {
		String msg = null;
		
		try {

            OrderDAO c = new OrderDAOImpl();	
            c.deleteOrder(orderId);
        
        } catch (Exception e) {
            e.printStackTrace();
        } 
		return msg;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getOrder(@PathVariable int orderId) {
		String msg = null;
		
		try {

            OrderDAO c = new OrderDAOImpl();	
            msg = c.getOrderStatus(orderId);
        
        } catch (Exception e) {
            e.printStackTrace();
        } 
		return msg;
	}
	
}
