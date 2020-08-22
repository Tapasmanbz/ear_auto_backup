package com.eargo.automation.runner;

import org.junit.runner.RunWith;
//import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;

//import org.testng.annotations.DataProvider;

import io.cucumber.junit.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/java/com/eargo/automation/features" }, plugin = { "json:target/cucumber.json",
		"html:target/site/cucumber-pretty" }, glue = "com/eargo/automation/steps", tags = {
				"" }, monochrome = true, strict = true, dryRun = false)

 public class TestRunner {

 }


// TestNG
//public class TestRunner extends AbstractTestNGCucumberTests {
//
//	@Override
//	@DataProvider
//	public Object[][] scenarios() {
//		return super.scenarios();
//	}
//}
