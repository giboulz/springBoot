package com.gbz.controller;

import org.springframework.web.bind.annotation.RestController;

import com.gbz.entity.Customer;
import com.gbz.services.CustomerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@Autowired
	CustomerService customerService; 
	
	
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
    @RequestMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
    	List<Customer> customers = customerService.getAllCustomers(); 
    	return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK); 
    }

}