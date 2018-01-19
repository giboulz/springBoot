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

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@SpringBootTest
@WebAppConfiguration
@ContextConfiguration(classes = { Application.class })
public class StepForLivingDocumentationTest {

	@Given("^I have numbers (\\d+) and (\\d+)$")
	public void ihave_numbers_and(int arg1, int arg2) throws Throwable {
		// for living doc purpose only
		assertThat(true, is(true));
	}

	@When("^I sum the numbers$")
	public void isum_the_numbers() throws Throwable {
		// for living doc purpose only
		assertThat(true, is(true));
	}

	@Then("^I should have (\\d+) as result$")
	public void ishould_have_as_result(int arg1) throws Throwable {
		// //for living doc purpose only
		assertThat(true, is(true));
	}
}
