package com.inetbanking.testCase;

import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import org.testng.annotations.Parameters;
import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();
	
	
	public String baseURL =readConfig.getApplicaionURL();
	public String username = readConfig.getUsername();
	public String password = readConfig.getPassword();
	
	public static WebDriver driver;
	
	public static Logger Logger;
	
@Parameters("browser")	
@BeforeClass
	public void SetUp(String br){
			
		Logger = Logger.getLogger("inetBankingProject");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",readConfig.getChromePath());
			
			driver = new ChromeDriver();
		}
		
		
		
	}
	
	@AfterClass
	public void TearDown() {
		driver.quit();
	}
	
}
