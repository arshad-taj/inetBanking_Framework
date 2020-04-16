package com.inetBanking.pageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inteBanking.testBase.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(name = "uid")
	@CacheLookup
	public WebElement userid;

	@FindBy(name = "password")
	@CacheLookup
	public WebElement password;
	
	@FindBy(name = "btnLogin")
	@CacheLookup
	public WebElement loginBtn;
	
	@FindBy(linkText = "Log out")
	@CacheLookup
	public WebElement logoutBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserId(String userId) {
		userid.sendKeys(userId);
		
	}
	
	public void enterPassword(String password) {
		this.password.sendKeys(password);
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
	
	public void clickLogoutBtn() {
		logoutBtn.click();
	}
}
