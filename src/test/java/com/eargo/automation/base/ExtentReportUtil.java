package com.eargo.automation.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.File;

public class ExtentReportUtil extends TestBase {

	boolean reportDir = new File(reportLocation + File.separator + timeStamp).mkdir();
	String fileName = reportLocation + File.separator + timeStamp + File.separator + "eargo_test_report.html";

	@SuppressWarnings("deprecation")
	public void ExtentReport() {
		// First is to create Extent Reports
		extent = new ExtentReports();

		System.out.println("fileName:" + fileName);

		// ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setReportName("Test report");

		extent.attachReporter(htmlReporter);

	}

	public void flushReport() {

		extent.flush();
	}

}