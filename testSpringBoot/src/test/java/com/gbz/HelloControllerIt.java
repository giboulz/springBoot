package com.gbz;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.gbz.entity.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIt {

	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
	}

	@Test
	public void getHello() throws Exception {
		ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
		assertThat(response.getBody(), equalTo("Greetings from Spring Boot!"));
	}

	@Test
	public void getListCustomers() throws Exception {
		// ResponseEntity<List<Customer>> response =
		// (ResponseEntity<List<Customer>>)
		// template.getForEntity(base.toString()+"/customers", new
		// ArrayList<Customer>().getClass() );

		// assertThat(response.getBody(), equalTo("<[{id=1, firstName=Jack,
		// lastName=Bauer}, {id=2, firstName=Chloe, lastName=O'Brian}, {id=3,
		// firstName=Kim, lastName=Bauer}, {id=4, firstName=David,
		// lastName=Palmer}, {id=5, firstName=Michelle, lastName=Dessler}]>"));
	}

}