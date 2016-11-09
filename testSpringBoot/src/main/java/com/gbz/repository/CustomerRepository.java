package com.gbz.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gbz.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);

	List<Customer> findByLastNameAndFirstName(String lastName, String firstName);
}