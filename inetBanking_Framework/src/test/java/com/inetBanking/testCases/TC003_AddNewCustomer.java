package com.inetBanking.testCases;

import org.testng.annotations.Test;

import com.inetBanking.pageLibrary.AddNewCustomerPage;
import com.inetBanking.pageLibrary.LoginPage;
import com.inetBanking.utilities.Helper;
import com.inteBanking.testBase.TestBase;

public class TC003_AddNewCustomer extends TestBase{
	
	@Test
	public void addNewCustomer() throws InterruptedException {
		
LoginPage _loginPage = new LoginPage();
		
		_loginPage.enterUserId(readConfig.getUserId());
		log.info("User ID entered");
		_loginPage.enterPassword(readConfig.getPassword());
		log.info("password entered");
		_loginPage.clickLoginBtn();
		log.info("Clicked Login button");
		
		Thread.sleep(1000);
		
		AddNewCustomerPage addCust = new AddNewCustomerPage();
		
		addCust.clickNewCustomer();
		
		addCust.setCustName("Fazeen");
		addCust.selectGender("female");
		addCust.dob("09","22", "2019");
		addCust.custAddress("Pisoli, Pune");
		addCust.city("pune");
		addCust.state("Maharashtra");
		addCust.pinNum("477824");
		addCust.telephoneNum("9595656566");
		
		String email = Helper.randomeString()+"@gmail.com";
		addCust.email(email);
		addCust.clickSubmit();
		
		
		
		
	}

}
