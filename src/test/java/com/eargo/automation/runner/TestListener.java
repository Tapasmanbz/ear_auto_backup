package com.eargo.automation.runner;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.eargo.automation.base.ExtentReportUtil;
import com.eargo.automation.base.TestBase;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

	ExtentReportUtil extentReportUtil = new ExtentReportUtil();

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started. " + result.getStartMillis());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Success. " + result.getEndMillis());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("On test failure");

		TestBase.features.log(Status.FAIL, "Test Case Failed is "+result.getName());
		TestBase.features.log(Status.FAIL, "Test Case Failed is "+result.getThrowable());
		try {
			 TestBase.features.fail("details").addScreenCaptureFromPath("screenshot.png");
			//extentReportUtil.takeScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("On test skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("On test percentage");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("On start");

		extentReportUtil.ExtentReport();

		// ToDo: Feature - Hard coding the feature name
		TestBase.features = extentReportUtil.extent.createTest(Feature.class, "Order Place Feature");
		System.out.println("#" + TestBase.features);
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On finish");
		extentReportUtil.flushReport();
	}


}
