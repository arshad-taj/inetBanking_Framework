package com.inetBanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.inteBanking.testBase.TestBase;

public class Helper extends TestBase {

	public static String timeStamp() {

		SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		return sd.format(new Date());
	}

	public static void screenshot(String screenshotName) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File("./Screenshots/" + screenshotName + "_" + timeStamp() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String screenshotWithFilePath(String screenshotName) {
		String filePath = "./Screenshots/" + screenshotName + "_" + timeStamp() + ".png";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath;
	}
	
	public static String randomeString() {
		return RandomStringUtils.randomAlphabetic(9);
	}

}
