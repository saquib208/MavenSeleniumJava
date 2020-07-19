package com.automation.testcase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pageobjects.LoginPage;


public class TC_Login_Test_001 extends BaseClass{
	
	@Test
	public void loginTest() throws InterruptedException, IOException {
		
		driver.get(baseURL);
		Thread.sleep(10);
		
		mylog.info("URL Opened");
		mylog.error("URL Opened");
		mylog.debug("URL Opened");
		mylog.warn("URL Opened");
		
		LoginPage lp= new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickSumbit();
		String title=driver.getTitle();
		System.out.println(title);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);
		if (title.contains("Find a Flight: Mercury Tours:"))
		{
		Assert.assertTrue(true);
		}	
			
		else
			
			
			
		{
			Assert.assertTrue(false);
			captureScreen(driver,"loginTest");
			
		}
		
	}

}
