package com.gbz;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.gbz.entity.Customer;
import com.gbz.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("h2")
public class DataAccessIntegrationTestTemplate {


	@Autowired
	private CustomerRepository repository;





	@Test
	public void testCreatingJpaObject() {
		repository.save(new Customer("TEST not save in database", "INTEGRATION2"));
		
		for (Customer customer : repository.findAll()) {
			System.out.println(customer.toString());
		}
		
	}



}