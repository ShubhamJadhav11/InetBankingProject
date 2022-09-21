package com.inetbanking.testCase;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.inetbanking.pageObject.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_Login_DDT_002 extends BaseClass{
	
	@Test(DataProvider="LoginData"){
	public void Login_DDT(String username, String pwd){
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		if (isAlertPresent()==true) {
		driver.switchTo().alert();
		driver.switchTo().defaultContent();
		Assert.assertTrue(false);
		Logger.warn("Login failed");
		
		}
		else {
		Assert.assertTrue(true);
		lp.clickLogout();
		driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}}
	
	public boolean isAlertPresent() {
		try
		{
			driver.switchTo().alert();
			return true;
			
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
			
		

	@DataProvider(name="LoginData")
	String [][] getData(){
		
		String path = "./src/test/java/com/inetbanking/testData/LoginData.xlsx";
		
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1");
		
		String LoginData [][]= new String [rownum][colcount];
		
		for ( int i = 1; i <rownum; i++) {
			for (int j=0;j<colcount;j++) {
				
				LoginData[i-1][j]=XLUtils.getCellData(path,"Sheet1", i, j);	
		}
		}
		return LoginData;
	}}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

