package com.eargo.automation.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome = true,
		features = "@target/rerun.txt", 
		plugin = { "rerun:target/rerun.txt" }
		)

public class FailedRunner {

}