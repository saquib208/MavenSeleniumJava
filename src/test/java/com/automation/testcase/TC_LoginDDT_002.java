package com.automation.testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.pageobjects.LoginPage;
import com.automation.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{	LoginPage lp;
	@Test(dataProvider="LoginData")
	public void loginTDD(String username,String password) throws InterruptedException 
	{

		driver.get(baseURL);
		Thread.sleep(5);
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickSumbit();
		
	
			if (lp.isLogoutPresent()==true) 
			{
				lp.clickLogout();
				Assert.assertTrue(true);
			}
				
			else {
					Assert.assertTrue(false);
				}
			
		
	}

	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException{
		
		
		String path =System.getProperty("user.dir")+"/src/test/java/com/automation/testdata/LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1",1);
		
		
		String logindata [][]= new String [rownum][colcount];
		
		for (int i=1;i<=rownum;i++)
		{
			for (int j=0;j<colcount;j++)
				logindata[i-1][j]=XLUtils.getCelData(path, "Sheet1", i, j);
				
		}
		
		return logindata;
	}

}
