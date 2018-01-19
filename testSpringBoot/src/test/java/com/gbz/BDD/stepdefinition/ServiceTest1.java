package com.gbz.bdd.stepdefinition;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.gbz.Application;
import com.gbz.entity.Customer;
import com.gbz.repository.CustomerRepository;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@SpringBootTest
@WebAppConfiguration
@ContextConfiguration(classes = { Application.class })
public class ServiceTest1 {

	private EmbeddedDatabase db;

	@Autowired
	private CustomerRepository repository;

	@Given("^my service exists$")
	public void my_service_exists() throws Throwable {
		System.out.println("début");
		// creates an HSQL in-memory database populated from default scripts
		// classpath:schema.sql and classpath:data.sql
		db = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).generateUniqueName(true)
				// .addDefaultScripts()
				.build();
	}

	@When("^I call my service$")
	public void step_i_call_my_service() throws Throwable {
		repository.save(new Customer("TEST", "INTEGRATION"));
	}

	@Then("^it should have been a success$")
	public void it_should_have_been_a_success() throws Throwable {
		for (Customer customer : repository.findAll()) {
			System.out.println(customer.toString());
		}
	}

	@Given("^users are presents in database$")
	public void users_are_presents_in_database() throws Throwable {

	}

	@When("^i add customers :$")
	public void step_i_add_customers(List<Customer> listCustomers) throws Throwable {
		repository.save(listCustomers);
	}

	@Then("^user list contains new entry :$")
	public void user_list_contains_new_entry(List<Customer> listCustomers) throws Throwable {
		for (Customer customer : listCustomers) {
			List<Customer> res = repository.findByLastNameAndFirstName(customer.getLastName(), customer.getFirstName());
			assertThat(res.size(), is(1));
		}
	}

	@Given("^there are (\\d+) cucumbers$")
	public void there_are_cucumbers(int arg1) throws Throwable {

	}

	@When("^I eat (\\d+) cucumbers$")
	public void step_i_eat_cucumbers(int arg1) throws Throwable {

	}

	@Then("^I should have (\\d+) cucumbers$")
	public void step_i_should_have_cucumbers(int arg1) throws Throwable {

	}

}
