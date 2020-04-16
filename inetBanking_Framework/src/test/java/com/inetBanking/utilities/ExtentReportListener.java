package com.inetBanking.utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener implements ITestListener {
	
	ExtentHtmlReporter extentHtmlReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;
	String reportName = "Test-Report-"+Helper.timeStamp()+".html";
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		extentTest = extentReports.createTest(result.getName());
		extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		
		
		
	}

	public void onTestFailure(ITestResult result) {
		extentTest = extentReports.createTest(result.getName());
		extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		try {
			extentTest.addScreenCaptureFromPath(Helper.screenshotWithFilePath(result.getName()));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		extentTest = extentReports.createTest(result.getName());
		extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.YELLOW));
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		extentHtmlReporter =new ExtentHtmlReporter(System.getProperty("user.dir")+ "/Reports/"+reportName);
		extentHtmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/Configuration/extent-config.xml");
		extentReports = new ExtentReports();
		
		extentReports.attachReporter(extentHtmlReporter);
		
		extentReports.setSystemInfo("Host name","localhost");
		extentReports.setSystemInfo("Environemnt","QA");
		extentReports.setSystemInfo("user","Arshad");
		
		extentHtmlReporter.config().setDocumentTitle("InetBanking Test Project"); // Tile of report
		extentHtmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
		extentHtmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		extentHtmlReporter.config().setTheme(Theme.DARK);
		
	}

	public void onFinish(ITestContext context) {
		extentReports.flush();
		
	}

}
