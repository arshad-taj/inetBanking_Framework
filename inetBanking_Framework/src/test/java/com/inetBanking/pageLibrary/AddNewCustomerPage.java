package com.inetBanking.pageLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.inteBanking.testBase.TestBase;

public class AddNewCustomerPage extends TestBase {
	
	public AddNewCustomerPage() {
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(linkText = "New Customer")
	public WebElement newCustomer;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//input[@name='name'][@type='text']")
	public WebElement txtCustomerName;
	
	@CacheLookup
	@FindBy(xpath = "//td[contains(text(),'Gender')]/following-sibling::td/input[1]")
	public WebElement rdoMale;
	
	@CacheLookup
	@FindBy(xpath = "//td[contains(text(),'Gender')]/following-sibling::td/input[2]")
	public WebElement rdoFemale;
	
	@CacheLookup
	@FindBy(name = "addr")
	public WebElement txtAddress;
	
	@CacheLookup
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	public WebElement txtDOB;
	
	@CacheLookup
	@FindBy(name = "city")
	public WebElement txtCity;
	
	@CacheLookup
	@FindBy(name = "state")
	public WebElement txtState;
	
	@CacheLookup
	@FindBy(name = "pinno")
	public WebElement txtPin;
	
	@CacheLookup
	@FindBy(name = "telephoneno")
	public WebElement txtPhoneNum;
	
	@CacheLookup
	@FindBy(name = "emailid")
	public WebElement txtEmailID;
	
	@CacheLookup
	@FindBy(name = "sub")
	public WebElement btnSubmit;
	
	//interactions
	
	public void clickNewCustomer() {
		newCustomer.click();
	}
	
	public void setCustName(String name) {
		txtCustomerName.sendKeys(name);
	}
	
	public void selectGender(String gender) {
		
		if(gender.equalsIgnoreCase("male"))
		{
			rdoMale.click();
		}
		else
		{
			rdoFemale.click();
		}
	}
	
	public void dob(String mm, String dd, String yyyy) {
		txtDOB.sendKeys(mm);
		txtDOB.sendKeys(dd);
		txtDOB.sendKeys(yyyy);
	}
	
	public void custAddress(String address) {
		txtAddress.sendKeys(address);
		
	}
	
	public void city(String cityName) {
		txtCity.sendKeys(cityName);
	}
	
	public void state(String stateName) {
		txtState.sendKeys(stateName);
	}
	
	public void pinNum(String pin) {
		txtPin.sendKeys(pin);
	}
	
	public void telephoneNum(String phoneNum) {
		txtPhoneNum.sendKeys(phoneNum);
	}
	
	public void email(String emailID) {
		txtEmailID.sendKeys(emailID);
	}
	
	public void clickSubmit() {
		btnSubmit.click();
	}
}
