package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageLibrary.LoginPage;
import com.inetBanking.utilities.ReadConfig;
import com.inteBanking.testBase.TestBase;

public class TC001_LoginTest extends TestBase {
	
	@Test
	public void loginTest() {
		LoginPage _loginPage = new LoginPage();
		
		_loginPage.enterUserId(readConfig.getUserId());
		log.info("User ID entered");
		
		_loginPage.enterPassword(readConfig.getPassword());
		log.info("password entered");
		
		_loginPage.clickLoginBtn();
		log.info("Clicked Login button");
		
		if(driver.getTitle().trim().equals("GTPL Bank Manager HomePage")) //GTPL Bank Manager HomePage
		{
			log.info("title matched");
			Assert.assertTrue(true);
		}
		else 
		{
			log.info("title doesn't match");
			Assert.assertTrue(false);		}
	}

}
