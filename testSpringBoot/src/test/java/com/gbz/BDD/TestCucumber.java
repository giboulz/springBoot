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
//@CucumberOptions(plugin = { "pretty",
//		"html:target/cucumber" }, features = "src/test/resources/features", monochrome = true
//		/*, glue = {"stepDefinition" }*/)
@CucumberOptions(plugin = { "json:target/cucumber.json" }, features = "src/test/resources/features"
,glue={"com.gbz.bdd","cucumber.api.spring"})
public class TestCucumber {

}
