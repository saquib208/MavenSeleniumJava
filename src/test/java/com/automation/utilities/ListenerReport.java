package com.automation.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerReport {
	

	
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest log;
	
	
	@BeforeTest
	public void setxtent() {
		String timeStamp =new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="TestReport-"+timeStamp+".html";
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		

		htmlReporter.config().setDocumentTitle("Automation Project");
		htmlReporter.config().setReportName("MyReport");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Platform","Windows 10");
		extent.setSystemInfo("Browser","Chrome");
		
	}
	
	@AfterMethod
	public void endReport() {
		
		extent.flush();
	}
	
	}


