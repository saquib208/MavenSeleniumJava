package com.automation.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport extends TestListenerAdapter{
	

	
	public void onTestStart(ITestResult tr) {
		System.out.println("Test Case Started"+tr.getName());
	}
	
	public void onTestSuccess(ITestResult tr) {
		System.out.println("Test Case Passed"+tr.getName());
	}
	
	public void onTestFailure(ITestResult tr) {
		System.out.println("Test Case Failed"+tr.getName());
	}
	
	public void onTestSkipped(ITestResult tr) {
		System.out.println("Test Case Skipped"+tr.getName());
		
	}
	
	


}
