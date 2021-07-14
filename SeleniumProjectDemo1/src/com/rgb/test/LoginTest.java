package com.rgb.test;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import co.rbg.Utilites.GenericFunction1;



public class LoginTest {
	
	public static ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"//ExtentReports//Test1.html");
	public static ExtentReports extent;
	public static ExtentTest extentLogger;
	public ExtentTest parentExtentLogger;
	
	public LoginTest() {
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReports\\Test1.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		parentExtentLogger = extent.createTest("Test1");
	}
@Test(priority = 0)
public void loginwithValidCredentials() throws InterruptedException, IOException
{
	
	
extentLogger = parentExtentLogger.createNode("with valid credentials");

	
	GenericFunction1 key= new GenericFunction1();
	key.openBrowser("Chrome");
key.enterURL("http://demo.guru99.com/test/newtours/index.php");
key.enterData("name", "userName", "mercury");
key.enterData("name", "password", "mercury");

TakesScreenshot ts = (TakesScreenshot) key.driver;
File source = ts.getScreenshotAs(OutputType.FILE);
String destination = System.getProperty("user.dir")+ "//Screenshots//Screen1.png";
File finalDestination = new File(destination);
FileUtils.copyFile(source, finalDestination);
extentLogger.log(Status.PASS,MarkupHelper.createLabel("TestCase1", ExtentColor.GREEN));
extentLogger.pass("",MediaEntityBuilder.createScreenCaptureFromPath(destination).build());
}

@Test(priority = 1)
public void loginwithInvalidCredentials() throws InterruptedException, IOException {
	
	
	extentLogger = parentExtentLogger.createNode("with invalid credentials");
//	FileInputStream fileRead = new FileInputStream(System.getProperty("user.dir")+ "\\Properties\\Test1.Properties");
//	
//	Properties p1 = new Properties();


	
	
		GenericFunction1 key= new GenericFunction1();
		key.openBrowser("Chrome");
	key.enterURL("http://demo.guru99.com/test/newtours/index.php");
	key.enterData("name", "userName", "mercury");
key.enterData("name", "password", "mercury");
	

	

	TakesScreenshot ts = (TakesScreenshot) key.driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	String destination = System.getProperty("user.dir")+ "//Screenshots//Screen2.png";
	File finalDestination = new File(destination);
	FileUtils.copyFile(source, finalDestination);
	extentLogger.log(Status.FAIL,MarkupHelper.createLabel("TestCase2", ExtentColor.RED));
	extentLogger.pass("",MediaEntityBuilder.createScreenCaptureFromPath(destination).build());
	
}


@AfterClass
public void afterClass() 
{
	
	
	extent.flush();
}

}
