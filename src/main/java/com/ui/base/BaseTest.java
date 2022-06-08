package com.ui.base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
 public static WebDriver driver;
 public static ExtentReports extentReports;
 public static ExtentTest extentTest;
	
 @BeforeSuite
 public void init() {
	 String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	 extentReports = new ExtentReports(System.getProperty("user.dir")+File.separator+"reports"+File.separator+"myreports"+dateName+".html");
 }
 
 @Parameters({"browser"})
 @BeforeMethod(alwaysRun=true)
 public void getDriver(ITestContext iTestContext, String browser) throws Exception {
		// System.out.println("getDriver Method!!");
		// iTestContext.getCurrentXmlTest().getSuite().getParameters();
//	 extentReports = new ExtentReports(System.getProperty("user.dir")+File.separator+"reports"+File.separator+"myreports.html");
		System.out.println("getDriver Method!!" + browser);
		if (browser.equals("chrome")) {
			System.out.println(" Executing on chrome");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			

		} else if (browser.equals("edge")) {
			System.out.println("Edge browser");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://trytestingthis.netlify.app/");
      
	}
 
 @AfterMethod
 public void closeDriver() {
	 extentReports.flush();
	 driver.close();
 }
}
