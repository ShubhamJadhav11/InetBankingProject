package com.inetbanking.testCase; 

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.LoginPage;


@Test
public class TC_LoginTest_001 extends BaseClass {
	
	public void LoginTest() {
		
		
		driver.get(baseURL);
		Logger.info("URL gets Launched");
		
	LoginPage lp = new LoginPage(driver);
	lp.setUserName(username);
	Logger.info("Username Entered");
	lp.setPassword(password);
	Logger.info("Password Entered");
	lp.clickLogin();
	
	
	if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
		
		
		Assert.assertTrue(true);
		Logger.info("Login Test Passed");
	}
	else {
		Assert.assertTrue(false);
		Logger.info("Logon Test Failed");
		
		
	}}	
	}
	


