package com.inetBanking.testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageLibrary.LoginPage;
import com.inetBanking.utilities.XLUtils;
import com.inteBanking.testBase.TestBase;

public class TC002_LoginTestDataProvider extends TestBase {
	
	@Test(dataProvider = "LoginData")
	public void loginTestDataProvider(String userid, String pwd) throws InterruptedException {
		LoginPage loginPage = new LoginPage();
		loginPage.enterUserId(userid);
		log.info("User ID entered");
		loginPage.enterPassword(pwd);
		log.info("Password entered");
		loginPage.clickLoginBtn();
		Thread.sleep(2500);
		log.info("clicked login button");
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			log.info("Login failed. Incorrect credentials");
			Assert.assertTrue(false, "Login failed. Incorrect credentials");
		}
		else
		{
			log.info("Login successful");
			Assert.assertTrue(true, "Login successful.");
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", loginPage.logoutBtn);
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", loginPage.logoutBtn);
			
			log.info("clicked logout button");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
	
	@DataProvider(name = "LoginData")
	public String[][] getData() throws Exception{
		String xlFilePath = System.getProperty("user.dir")+"\\src\\test\\java\\com\\inetBanking\\testData\\LoginData.xlsx";
		int rowCount = XLUtils.getRowCount(xlFilePath, "Sheet1");
		int cellCount = XLUtils.getCellCount(xlFilePath, "Sheet1", 1);
		
		String loginData[][] = new String [rowCount][cellCount];
		
		for (int i=1;i<rowCount;i++) 
		{
			for (int j=0;j<cellCount;j++) 
			{
				loginData[i-1][j]=XLUtils.getCellData(xlFilePath, "Sheet1", i, j); // 'i-1' as array starts with 0 and we are starting from row 1 in escel file
			}
		}
		
		return loginData;
		
	}
		
	

}
