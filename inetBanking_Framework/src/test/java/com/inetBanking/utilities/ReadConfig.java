package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	
	public ReadConfig() {
		 
		try {
			FileInputStream fis =  new FileInputStream("./Configuration/config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getApplicationUrl() {
		String url = prop.getProperty("url");
		return url;
	}
	
	public String getUserId() {
		String userid = prop.getProperty("userid");
		return userid;
	}
	
	public String getPassword() {
		String password = prop.getProperty("password");
		return password;
	}
}
