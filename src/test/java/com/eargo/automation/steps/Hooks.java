package com.eargo.automation.steps;

import com.eargo.automation.base.TestBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends TestBase {

	@Before
	public static void setup() {
		initialization();
	}

	@After
	public static void tearDown() {
//		tearDownTest();
	}
}
