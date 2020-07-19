package com.automation.testcase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.automation.utilities.ReadConfig;


public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	
	
	public String baseURL=readconfig.getApplicationURL();
	/*public String baseURL="http://www.google.com";*/
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger mylog=LogManager.getLogger(BaseClass.class.getName());
	
	
	
	@Parameters("browsers")
	@BeforeClass
	public void setup (String br) {
		

		Logger logger=LogManager.getLogger(BaseClass.class);
		
		if(br.equals("chrome"))
		{			
		/*System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");*/
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		driver = new ChromeDriver ();
		}
		
		else if (br.equals("firefox")){
			
			System.setProperty("webdriver.firefox.driver",readconfig.geFFPath());
			driver = new FirefoxDriver ();
			
		}
		
		else {

			System.setProperty("webdriver.edge.driver",readconfig.getEdgePath());
			driver = new EdgeDriver ();
			
		}

	}
	
	@AfterClass
	public void tearDown() {
		
		driver.close();
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException 
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target =new File(System.getProperty("user.dir")+"/Screenshot/"+tname+".png");
		FileUtils.copyFile(source,target);
		System.out.println("Screenshot taken");
		
		
	}


}
