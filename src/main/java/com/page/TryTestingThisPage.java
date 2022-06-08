package com.page;

import org.openqa.selenium.By;

import com.actions.ActionEngine;

public class TryTestingThisPage extends ActionEngine {
	public By options = By.id("option");
	public By doubleClick = By.xpath("//button[text()='Double-click me']");
	public By header = By.xpath("//h2[text()='This is your layout two']");
	public By textFirstName=By.xpath("//input[@id='fname']");
	public By textLastName=By.xpath("//input[@id='lname']");
	public By radioGender=By.xpath("//input[@id='male']");
	
	
    public void selectDropdownValue() {
    	
    	//click(options, "options dropdown");
    	//selectByVisibleText(options, "Option 1", "options");
    	//selectByValue(options, "option 3", "options");
    	//selectByIndex(options, 1, "options");
    	//click(doubleClick, "Header");
    	click(doubleClick, "double click");
    	click(textFirstName,"sendkeys");
    	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
	public void fillName() {
		try {
			type(textFirstName, "first name", "First name locator");
			type(textLastName, "last name", "Last name locator");
			click(radioGender, "Gender locator");
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
