package com.gbz.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gbz.entity.Customer;
import com.gbz.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {
	private static final Logger log = LoggerFactory.getLogger(CustomerService.class);
	@Autowired
	CustomerRepository customerRepository;

	public List<Customer> getAllCustomers() {
		List<Customer> customers = (List<Customer>) customerRepository.findAll();

		for (Customer customer : customers) {
			log.info(customer.toString());
		}
		
		return customers; 
	}

}
