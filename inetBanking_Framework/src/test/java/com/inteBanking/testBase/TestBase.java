package com.inteBanking.testBase;


import java.io.FileNotFoundException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;


public class TestBase {
	public ReadConfig readConfig;
	public static WebDriver driver;
	public Properties prop;
	public WebDriverWait wait;
	public static Logger log;
	
	public TestBase() {
		
	}
	@Parameters("browser")
	@BeforeClass
	public void setUp(String browser) throws FileNotFoundException {
		readConfig = new ReadConfig();
		log = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		selectBrowser(browser);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void selectBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		//hitting url
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(readConfig.getApplicationUrl());
		log.info("URL entered");
		
	}
	
	public void expliciteWait() {
		wait = new WebDriverWait(driver, 30);
		
	}
	
	public boolean isAlertPresent() {
		try 
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e) 
		{
			return false;
		}
	}
}
