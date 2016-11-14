package com.gbz.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.gbz.entity.Customer;
import com.gbz.services.CustomerService;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("h2")
public class HelloControllerTest {

	@Autowired
	private MockMvc mvc;

	@Mock
	CustomerService customerService;

	@InjectMocks
	private HelloController helloController;

	public static final long CUSTOMER_ID = 1;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

		mvc = MockMvcBuilders.standaloneSetup(helloController).build();

	}

	@Test
	public void getHello() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().string(equalTo("Greetings from Spring Boot!")));
	}

	@Test
	public void getAllCustomers_get_all_customers() throws Exception {

		// Arrange
		List<Customer> customersFixture = new ArrayList<Customer>();
		for (int i = 0; i < 3; i++) {
			Customer customer = new Customer("Prenom" + i, "Nom" + i);
			customer.setId(Long.valueOf(i));
			customersFixture.add(customer);
		}

		when(customerService.getAllCustomers()).thenReturn(customersFixture);

		// Act
		mvc.perform(MockMvcRequestBuilders.get("/customers").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$[0].firstName", is("Prenom0")))
				.andExpect(jsonPath("$[0].lastName", is("Nom0"))).andExpect(jsonPath("$[0].id", is(0)))
				.andExpect(jsonPath("$[1].firstName", is("Prenom1"))).andExpect(jsonPath("$[1].lastName", is("Nom1")))
				.andExpect(jsonPath("$[1].id", is(1))).andExpect(jsonPath("$[2].firstName", is("Prenom2")))
				.andExpect(jsonPath("$[2].lastName", is("Nom2"))).andExpect(jsonPath("$[2].id", is(2)));

		// Assert
		verify(customerService).getAllCustomers();

	}

	@Test
	public void getCustomer_get_one_customer() throws Exception {

		// Arrange
		Customer customerFixture = new Customer("prenom", "nom");
		customerFixture.setId(CUSTOMER_ID);
		when(customerService.getCustomerById(CUSTOMER_ID)).thenReturn(customerFixture);

		// Act
		mvc.perform(MockMvcRequestBuilders.get("/customer/" + CUSTOMER_ID).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.firstName", is("prenom")))
				.andExpect(jsonPath("$.lastName", is("nom"))).andExpect(jsonPath("$.id", is((int)CUSTOMER_ID)));

		// Assert
		verify(customerService).getCustomerById(CUSTOMER_ID);
	}

	@Test
	public void addNewCustomer_adding_new_customer() throws Exception {

		// Arrange
		Customer customerFixture = new Customer("prenom", "nom");
		customerFixture.setId(CUSTOMER_ID);

		Customer customerFixtureFromCreation = new Customer("prenom", "nom");
		customerFixtureFromCreation.setId(Long.valueOf(999));

		when(customerService.createCustomer(any(Customer.class))).thenReturn(customerFixtureFromCreation);

		// Act
		Gson gson = new Gson();
		String json = gson.toJson(customerFixture);

		mvc.perform(MockMvcRequestBuilders.post("/customer").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isCreated())
				.andExpect(jsonPath("$.id", is(999))).andExpect(jsonPath("$.firstName", is("prenom")))
				.andExpect(jsonPath("$.lastName", is("nom")));

		// Assert
		verify(customerService).createCustomer(any(Customer.class));
		// does not work, detect that customerFixture is different from what
		// have been passed in parameters.
		// verify(customerService).createCustomer(customerFixture);
	}

	@Test
	public void updateCustomer_updating_a_customer() throws Exception {

		// Arrange
		Customer customerFixture = new Customer("prenom", "nom");

		Customer customerFixtureFromUpdate = new Customer("prenomUpdated", "nomUpdated");
		customerFixtureFromUpdate.setId(Long.valueOf(999));

		when(customerService.updateCustomer(eq(CUSTOMER_ID), any(Customer.class)))
				.thenReturn(customerFixtureFromUpdate);

		// Act
		Gson gson = new Gson();
		String json = gson.toJson(customerFixture);

		mvc.perform(MockMvcRequestBuilders.put("/customer/" + CUSTOMER_ID).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(jsonPath("$.id", is(999)))
				.andExpect(jsonPath("$.firstName", is("prenomUpdated")))
				.andExpect(jsonPath("$.lastName", is("nomUpdated")));

		// Assert
		verify(customerService).updateCustomer(eq(CUSTOMER_ID), any(Customer.class));

	}

	@Test
	public void deleteCustomer_delete_a_customer() throws Exception {

		// Arrange
		Mockito.doNothing().when(customerService).deleteCustomer(CUSTOMER_ID);

		// Act
		mvc.perform(MockMvcRequestBuilders.delete("/customer/" + CUSTOMER_ID).accept(MediaType.APPLICATION_JSON));

		// Assert
		verify(customerService).deleteCustomer(CUSTOMER_ID);
	}

}