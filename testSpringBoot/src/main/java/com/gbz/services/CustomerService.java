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

	public Customer getCustomerById(long id) {
		Customer customer = customerRepository.findOne(id);
		return customer;
	}

	public Customer createCustomer(Customer data) {
		Customer customerSaved = customerRepository.save(data);
		return customerSaved;
	}

	public Customer updateCustomer(long idCustomer, Customer customer) {
		Customer entity = customerRepository.findOne(idCustomer);
		entity.setFirstName(customer.getFirstName());
		entity.setLastName(customer.getLastName());
		return customerRepository.save(entity);
	}

	public void deleteCustomer(long idCustomer) {
		customerRepository.delete(idCustomer);
	}

}
