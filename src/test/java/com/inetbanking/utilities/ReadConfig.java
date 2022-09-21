package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	
	public ReadConfig(){
		
		File src = new File ("./Configuration/Config.properties");
		
		try {
			
		FileInputStream fis = new FileInputStream(src);
		
		pro = new Properties();
		pro.load(fis);
		}
		
		catch(Exception e) {
			
			System.out.println("Exception is "+ e.getMessage());
		}		
		}	
	
	
public String getApplicaionURL() {
	
	String url = pro.getProperty("baseURL");
	return url;
}

public String getUsername() {
	String username = pro.getProperty("username");
	return username;
}


public String getPassword() {
	String pass = pro.getProperty("password");
	return pass;
	
}


public String getChromePath() {
	String chromepath = pro.getProperty("chromepath");
	return chromepath;
}





}





























