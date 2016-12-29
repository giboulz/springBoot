package com.gbz.bdd;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

// @ActiveProfiles("test")
@CucumberOptions(plugin = { "json:target/cucumber.json" }, features = "src/test/resources/features")
public class TestCucumberForLivingDoc {

}
