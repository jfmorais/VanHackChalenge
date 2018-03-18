package com.skipthedishes.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.skipthedishes.dao.CustomerDAO;
import com.skipthedishes.dao.CustomerDAOImpl;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
	
	@RequestMapping("/Auth")
	public String authenticate(@RequestParam("email") String email, @RequestParam("password")String password) {
		try {

            // Authenticate the user using the credentials provided
            CustomerDAO c = new CustomerDAOImpl();	
            String message = c.authenticateCustomer(email, password);

            
            // Return the token on the response
            return message;

        } catch (Exception e) {
            return e.getMessage();
        } 
		
	}
}
