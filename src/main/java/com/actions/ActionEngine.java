package com.actions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.ui.base.BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionEngine extends BaseTest{

	public void type(By locator, String data, String locatorName) {
		boolean flag = false;
		try {
			driver.findElement(locator).sendKeys(data);
			flag = true;
		} catch(Exception e) {
			e.printStackTrace();
			//Assert.assertTrue(flag);
		}finally {
			if(flag) {
				extentTest.log(LogStatus.PASS, "Data is successfully entered into "+locatorName+extentTest.addScreenCapture(getScreenShot(driver, locatorName)));
			}else {
				extentTest.log(LogStatus.FAIL, "Data is not entered into "+locatorName+extentTest.addScreenCapture(getScreenShot(driver, locatorName)));
			}
		}
	}
	
	public void click(By locator, String locatorName) {
		boolean flag = false;
		try {
			driver.findElement(locator).click();
			flag = true;
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				extentTest.log(LogStatus.PASS, "Successfully clicked on "+locatorName);
			}else {
				extentTest.log(LogStatus.FAIL, "Failed to clicke on "+locatorName);
			}
		}
	}
	
	public String getScreenShot(WebDriver webDriver, String screenShotName) {
		String destination = System.getProperty("user.dir");
		try {
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot)webDriver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			destination = destination+File.separator+"FailedScreenshots"+File.separator+"SS"+dateName+".png";
			
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return destination;
	}
	
	
	public void selectByVisibleText(By options, String value, String locatorName) {
		try {
			
			WebElement webElement = driver.findElement(options);
			highlightElement(webElement);
			Select select = new Select(webElement);
			select.selectByVisibleText(value);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectByIndex(By options, int index, String locatorName) {
		try {
			
			WebElement webElement = driver.findElement(options);
			highlightElement(webElement);
			Select select = new Select(webElement);
			select.selectByIndex(index);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectByValue(By options, String value, String locatorName) {
		try {
			
			WebElement webElement = driver.findElement(options);
			highlightElement(webElement);
			Select select = new Select(webElement);
			select.selectByValue(value);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	   * This method is used to highlight element
	   * 
	   * @param webElement an webobject
	   */
	  public void highlightElement(WebElement webElement) {
	      JavascriptExecutor js = (JavascriptExecutor) driver;
	      js.executeScript(
	          "arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
	          webElement);
	      try {
	        Thread.sleep(5000);
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      }
	      js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", webElement);
	  }

	  
		public void doubleClick(By dClick, String locatorName) {
			try {
				
				WebElement webElement = driver.findElement(dClick);
				highlightElement(webElement);
				Actions actions = new Actions(driver);
				actions.doubleClick(webElement);
				
			} catch (Exception e) {
				e.printStackTrace();}
				}
			
		
			public void sendKeys(By sendkeys, String locatorName) {
				try {
					
					WebElement webElement = driver.findElement(sendkeys);
					highlightElement(webElement);
					webElement.sendKeys("");
					
				} catch (Exception e) {
					e.printStackTrace();}
		}
		
			public void click(By click) {
				try {
					
					WebElement webElement = driver.findElement(click);
					highlightElement(webElement);
					Actions actions = new Actions(driver);
					actions.click(webElement);
					
				} catch (Exception e) {
					e.printStackTrace();}
					}
				
		}
		
		
					
					
				
					
				
		
		
		
		
		
		

