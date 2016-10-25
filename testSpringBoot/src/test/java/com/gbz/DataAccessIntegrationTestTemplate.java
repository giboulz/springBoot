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
import org.springframework.test.context.junit4.SpringRunner;

import com.gbz.entity.Customer;
import com.gbz.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataAccessIntegrationTestTemplate {

	private EmbeddedDatabase db;

	@Autowired
	private CustomerRepository repository;

	@Before
	public void setUp() {
		// creates an HSQL in-memory database populated from default scripts
		// classpath:schema.sql and classpath:data.sql
		db = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).generateUniqueName(true)
				// .addDefaultScripts()
				.build();
	}

	@Test
	@Ignore
	public void testDataAccess() {
		JdbcTemplate template = new JdbcTemplate(db);
		int rowCount = template.queryForObject("select count(*) from customer", Integer.class);
		System.out.println(rowCount);

	}

	@Test
	public void testCreatingJpaObject() {
		repository.save(new Customer("TEST", "INTEGRATION"));
		
		for (Customer customer : repository.findAll()) {
			System.out.println(customer.toString());
		}
	}

	@After
	public void tearDown() {
		db.shutdown();
	}

}